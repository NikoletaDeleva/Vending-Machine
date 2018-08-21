package com.egtinteractive.vending_machine;

import java.util.ArrayList;
import java.util.List;

import com.egtinteractive.inventory.Inventory;
import com.egtinteractive.inventory.Item;
import com.egtinteractive.io.IO;

public class VendingMachine {
    private final Inventory inventory;
    private final IO io;
    private long coins;
    private long totalMoney;
    private StateMachine state;

    public VendingMachine(IO io, Inventory inventory) {
	this.coins = 0L;
	this.setTotalMoney(0L);
	this.state = StateMachine.STAND_BY;
	this.inventory = inventory;
	this.io = io;
    }

    public StateMachine getState() {
	return this.state;
    }

    void setState(final StateMachine state) {
	this.state = state;
    }

    public long getCoins() {
	return this.coins;
    }

    public IO getIo() {
	return io;
    }

    public Inventory getInventory() {
	return this.inventory;
    }

    public long getTotalMoney() {
	return totalMoney;
    }

    void setTotalMoney(long totalMoney) {
	this.totalMoney = totalMoney;
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

    public Item selectItem(final String name) {
	return this.state.selectItem(this, name) ? this.inventory.getItemByName(name) : null;
    }

    public boolean takeItem() {
	return state.takeItem(this);
    }

    public boolean addItem(final String name, long price, final int quantity) {
	return this.state.addItem(this, name, price, quantity);
    }

    public long service() {
	final long moneyReturn = this.returnCoinsToCustomer();
	return this.state.service(this) ? moneyReturn : null;
    }

    public boolean endService() {
	return this.state.endService(this);
    }

    public List<Item> listItems() {
	return new ArrayList<>(inventory.getProducts().keySet());
    }

}
