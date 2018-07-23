package com.egtinteractive.vending_machine;

import java.math.BigDecimal;

public enum StateMachine implements Machine {
    STAND_BY {

	public boolean putCoins(VendingMachine machine, BigDecimal money) {
	    
	    machine.setMoney(money);
	    machine.setState(StateMachine.SELECT_ITEM);
	    
	    return true;
	}

	public boolean selectItem(VendingMachine machine, String name) {
	    return false;
	}

	public boolean takeItem(VendingMachine machine) {
	    return false;
	}

	public boolean service(VendingMachine machine) {
	    machine.setState(StateMachine.SERVICE);
	    return true;
	}

	public boolean returnMoney(VendingMachine machine) {
	    return false;
	}

	public boolean addProduct(VendingMachine machine, String name, long price, int quantity) {
	    return false;
	}

	public boolean fixMachine(VendingMachine machine) {
	    return false;
	}

	public boolean endService(VendingMachine machine) {
	    return false;
	}

    },
    SELECT_ITEM {

	public boolean putCoins(VendingMachine machine, BigDecimal money) {
	    
	    machine.setMoney(money);
	    
	    return true;
	}

	public boolean selectItem(VendingMachine machine, String name) {
	    // functionality
	    machine.setState(StateMachine.TAKE_ITEM);
	    return true;
	}

	public boolean takeItem(VendingMachine machine) {
	    return false;
	}

	public boolean service(VendingMachine machine) {
	    machine.setState(StateMachine.SERVICE);
	    return false;
	}

	public boolean returnMoney(VendingMachine machine) {
	    // functionality
	    machine.setState(StateMachine.STAND_BY);
	    return true;
	}

	public boolean addProduct(VendingMachine machine, String name, long price, int quantity) {
	    return false;
	}

	public boolean fixMachine(VendingMachine machine) {
	    return false;
	}

	public boolean endService(VendingMachine machine) {
	    return false;
	}

    },
    TAKE_ITEM {

	public boolean putCoins(VendingMachine machine, BigDecimal money) {
	    return false;
	}

	public boolean selectItem(VendingMachine machine, String name) {
	    return false;
	}

	public boolean takeItem(VendingMachine machine) {
	    // functionality

	    machine.setState(StateMachine.STAND_BY);
	    return true;
	}

	public boolean service(VendingMachine machine) {
	    machine.setState(StateMachine.SERVICE);
	    return true;
	}

	public boolean returnMoney(VendingMachine machine) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean addProduct(VendingMachine machine, String name, long price, int quantity) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean fixMachine(VendingMachine machine) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean endService(VendingMachine machine) {
	    // TODO Auto-generated method stub
	    return false;
	}

    },
    SERVICE {

	public boolean putCoins(VendingMachine machine, BigDecimal money) {
	    return false;
	}

	public boolean selectItem(VendingMachine machine, String name) {
	    return false;
	}

	public boolean takeItem(VendingMachine machine) {
	    return false;
	}

	public boolean service(VendingMachine machine) {
	    return false;
	}

	public boolean returnMoney(VendingMachine machine) {
	    return false;
	}

	public boolean addProduct(VendingMachine machine, String name, long price, int quantity) {
	    
	    return true;
	}

	public boolean fixMachine(VendingMachine machine) {
	    // functionality
	    return false;
	}

	public boolean endService(VendingMachine machine) {
	    machine.setState(StateMachine.STAND_BY);
	    return false;
	}

    }
}
