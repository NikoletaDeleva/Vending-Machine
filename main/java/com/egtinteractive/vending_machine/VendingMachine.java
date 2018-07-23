package com.egtinteractive.vending_machine;

import java.math.BigDecimal;


public class VendingMachine {
    private static final int DEFAUL_INVENTORY_SIZE = 16;
    private static VendingMachine vendingMachineInstance = null;
    private BigDecimal money;
    private StateMachine state;
    private Inventory inventory;
    private Item currentItem;

    public VendingMachine(int size){
	this.money = BigDecimal.ZERO;
	this.state = StateMachine.STAND_BY;
	this.inventory = new Inventory(size);
	currentItem = null;
    }

    public static VendingMachine getInstance() {
	if (vendingMachineInstance == null) {
	    vendingMachineInstance = new VendingMachine(DEFAUL_INVENTORY_SIZE);
	}

	return vendingMachineInstance;
    }

    public void setState(StateMachine state) {
	this.state = state;
    }
    
    void setMoney(final BigDecimal money) {
	
    }

}
