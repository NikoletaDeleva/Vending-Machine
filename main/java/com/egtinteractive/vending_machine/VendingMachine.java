package com.egtinteractive.vending_machine;

import java.util.Map;

import com.egtinteractive.inventory.Inventory;
import com.egtinteractive.inventory.Item;

public class VendingMachine {
    private static final int DEFAUL_INVENTORY_SIZE = 16;
    private static VendingMachine vendingMachineInstance = null;
    private long coins;
    private long totalMoney;
    private StateMachine state;
    private final Inventory inventory;

    private VendingMachine(final int size) {
	this.coins = 0L;
	this.setTotalMoney(0L);
	this.state = StateMachine.STAND_BY;
	this.inventory = new Inventory(size);
    }

    public static VendingMachine getInstance(int size) {
	if (vendingMachineInstance == null) {
	    vendingMachineInstance = new VendingMachine(DEFAUL_INVENTORY_SIZE);
	}
	return vendingMachineInstance;
    }

    void setState(final StateMachine state) {
	this.state = state;
    }

    long getCoins() {
	return this.coins;
    }

    void addCoinsToMachine(final long coins) {
	this.coins += coins;
    }

    void takeCustomerCoins(final Item specificItem) {
	this.coins -= specificItem.getPrice();
	this.setTotalMoney(this.getTotalMoney() + specificItem.getPrice());
    }

    long returnCoinsToCustomer() {
	final long moneyToReturn = this.coins;
	this.coins = 0L;
	return moneyToReturn;
    }

    public long putCoins(final long coins) {
	this.state.putCoins(this, coins);
	return this.coins;
    }

    public Inventory getInventory() {
	return this.inventory;
    }

    public Item selectItem(final String name) {
	return this.state.selectItem(this, name) ? this.inventory.getItemByName(name) : null;
    }

    public boolean takeItem() {
	return state.takeItem(this);
    }

    public long getTotalMoney() {
	return totalMoney;
    }

    public void setTotalMoney(long totalMoney) {
	this.totalMoney = totalMoney;
    }

    public boolean addItem(final String name, long price, int quantity) {
	return this.state.addItem(this, name, price, quantity);
    }

    public int getDifferentItemsCount() {
	return inventory.getDifferentItemsCount();
    }

    public int getAllItemsCount() {
	return inventory.getAllItemsCount();
    }

    public int getSpecificItemCount(final String name) {

	Item item = inventory.getItemByName(name);

	return inventory.getAmountOfItem(item);
    }

    public long service() {
	long moneyReturn = this.returnCoinsToCustomer();
	this.setState(StateMachine.SERVICE);
	return moneyReturn;
    }

    public boolean endService() {
	return this.state.endService(this);
    }

    public long getItemPrice(final String name) {
	Item item = inventory.getItemByName(name);
	return item.getPrice();
    }

    public void loadHomePage() {
	if (inventory.getProducts().isEmpty()) {

	    System.out.println("Machine need service!");

	} else {
	    final StringBuilder sb = new StringBuilder();
	    sb.append(System.lineSeparator() + "CREDIT:" + getCoins() + "-----------------------------------------"
		    + System.lineSeparator() + "-------------------------------------------------"
		    + System.lineSeparator());
	    sb.append(String.format("%s %30s %2s" + System.lineSeparator()
		    + "-------------------------------------------------" + System.lineSeparator(), "PRODUCT:",
		    "PRICE:", "Quantity:"));
	    for (Map.Entry<Item, Integer> entry : this.getInventory().getProducts().entrySet()) {

		final String name = entry.getKey().getName();
		final long price = entry.getKey().getPrice();
		int quantity = entry.getValue();
		sb.append(String.format("%s %33s %5s" + System.lineSeparator(), name, price, quantity));
	    }
	    sb.append("-------------------------------------------------" + System.lineSeparator()
		    + System.lineSeparator());
	    System.out.println(sb);
	}

    }

    public StateMachine getState() {
	return this.state;
    }
}
