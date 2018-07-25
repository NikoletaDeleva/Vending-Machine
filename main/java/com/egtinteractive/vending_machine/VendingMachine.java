package com.egtinteractive.vending_machine;

public class VendingMachine {
    private static final int DEFAUL_INVENTORY_SIZE = 16;
    private static VendingMachine vendingMachineInstance = null;
    private long coins;
    private long totalMoney;
    private StateMachine state;
    private final Inventory inventory;

    private VendingMachine(int size) {
	this.coins = 0L;
	this.setTotalMoney(0L);
	this.state = StateMachine.STAND_BY;
	this.inventory = new Inventory(size);
    }

    public static VendingMachine getInstance() {
	if (vendingMachineInstance == null) {
	    vendingMachineInstance = new VendingMachine(DEFAUL_INVENTORY_SIZE);
	}
	return vendingMachineInstance;
    }

    void setState(StateMachine state) {
	this.state = state;
    }

    public long putCoins(final long coins) {
	if (coins > 0) {
	    return coins;
	}
	this.state.putCoins(this, coins);
	return this.coins;
    }

    long getCoins() {
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

    void addCoinsToMachine(final long coins) {
	this.coins += coins;
    }

    void takeCustomerCoins(Item specificItem) {
	this.coins -= specificItem.getPrice();
	this.setTotalMoney(this.getTotalMoney() + specificItem.getPrice());
    }

    long returnCoinsToCustomer() {
	final long moneyToReturn = this.coins;
	this.coins = 0L;
	return moneyToReturn;
    }

    public long getTotalMoney() {
	return totalMoney;
    }

    public void setTotalMoney(long totalMoney) {
	this.totalMoney = totalMoney;
    }
    
    public boolean addItem(String name, long price, int quantity) {
	return this.state.addItem(this, name, price, quantity);
    }
    
    public int getDifferentItemsCount() {
	return inventory.getDifferentItemsCount();
    }
    
    public int getAllItemsCount () {
	return inventory.getAllItemsCount();
    }
}
