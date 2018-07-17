package com.egtinteractive.vending_machine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private static VendingMachine vendingMachineInstance = null;
    private float money;
    private Machine state;
    private Map<Item, Integer> products;
    private Item currentItem;

    public VendingMachine() {
	this.money = 0;
	this.state = Machine.STAND_BY;
	this.products = new HashMap<Item, Integer>();
	currentItem = null;
    }

    public boolean takeMoney() {

	return true;
    }

    public void setState(Machine state) {
	this.state = state;
    }

    public static VendingMachine getInstance() {
	if (vendingMachineInstance == null) {
	    vendingMachineInstance = new VendingMachine();
	}

	return vendingMachineInstance;
    }
}
