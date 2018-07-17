package com.egtinteractive.vending_machine;

public enum Machine implements IMachine {
    STAND_BY {

	public boolean putCoins(VendingMachine machine, long coins) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean selectItem(VendingMachine machine, String name) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean takeItem(VendingMachine machine) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean service(VendingMachine machine) {
	    // TODO Auto-generated method stub
	    return false;
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
    SELECT_ITEM {

	public boolean putCoins(VendingMachine machine, long coins) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean selectItem(VendingMachine machine, String name) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean takeItem(VendingMachine machine) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean service(VendingMachine machine) {
	    // TODO Auto-generated method stub
	    return false;
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
    TAKE_ITEM {

	public boolean putCoins(VendingMachine machine, long coins) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean selectItem(VendingMachine machine, String name) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean takeItem(VendingMachine machine) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean service(VendingMachine machine) {
	    // TODO Auto-generated method stub
	    return false;
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

	public boolean putCoins(VendingMachine machine, long coins) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean selectItem(VendingMachine machine, String name) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean takeItem(VendingMachine machine) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean service(VendingMachine machine) {
	    // TODO Auto-generated method stub
	    return false;
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

    }
}
