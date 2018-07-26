package com.egtinteractive.vending_machine;

public enum StateMachine implements Machine {
    STAND_BY {

	@Override
	public boolean putCoins(VendingMachine machine, long coins) {
	    if (coins <= 0) {
		return false;
	    }
	    machine.addCoinsToMachine(coins);
	    machine.setState(StateMachine.SELECT_ITEM);
	    return true;
	}

	@Override
	public boolean selectItem(VendingMachine machine, String name) {
	    return false;
	}

	@Override
	public boolean takeItem(VendingMachine machine) {
	    return false;
	}

	@Override
	public boolean returnMoney(VendingMachine machine) {
	    return false;
	}

	@Override
	public boolean addItem(VendingMachine machine, String name, long price, int quantity) {
	    return false;
	}

	@Override
	public boolean service(VendingMachine machine) {
	    machine.setState(StateMachine.SERVICE);
	    return true;
	}

	@Override
	public boolean endService(VendingMachine machine) {
	    return false;
	}

    },
    SELECT_ITEM {
	@Override
	public boolean putCoins(VendingMachine machine, long coins) {
	    machine.addCoinsToMachine(coins);
	    return true;
	}

	@Override
	public boolean selectItem(VendingMachine machine, String name) {

	    Item specificItem = machine.getInventory().getItemByName(name);

	    if (machine.getCoins() < specificItem.getPrice()) {
		return false;
	    }
	    if (machine.getInventory().getAmountOfItem(specificItem) > 0) {
		machine.getInventory().getOneSpecificItemFromInventory(specificItem);
		machine.takeCustomerCoins(specificItem);
		machine.setState(StateMachine.TAKE_ITEM);
		return true;
	    }
	    return false;
	}

	@Override
	public boolean takeItem(VendingMachine machine) {
	    return false;
	}

	@Override
	public boolean returnMoney(VendingMachine machine) {
	    machine.returnCoinsToCustomer();
	    machine.setState(StateMachine.STAND_BY);
	    return true;
	}

	@Override
	public boolean addItem(VendingMachine machine, String name, long price, int quantity) {
	    return false;
	}

	@Override
	public boolean service(VendingMachine machine) {
	    machine.setState(StateMachine.SERVICE);
	    return false;
	}

	@Override
	public boolean endService(VendingMachine machine) {
	    return false;
	}

    },
    TAKE_ITEM {
	@Override
	public boolean putCoins(VendingMachine machine, long coins) {
	    return false;
	}

	@Override
	public boolean selectItem(VendingMachine machine, String name) {
	    return false;
	}

	@Override
	public boolean takeItem(VendingMachine machine) {
	    if (machine.getCoins() > 0) {
		machine.returnCoinsToCustomer();
	    }
	    machine.setState(StateMachine.STAND_BY);
	    return true;
	}

	@Override
	public boolean returnMoney(VendingMachine machine) {
	    return false;
	}

	@Override
	public boolean addItem(VendingMachine machine, String name, long price, int quantity) {
	    return false;
	}

	@Override
	public boolean service(VendingMachine machine) {
	    machine.setState(StateMachine.SERVICE);
	    return true;
	}

	@Override
	public boolean endService(VendingMachine machine) {
	    return false;
	}

    },
    SERVICE {
	@Override
	public boolean putCoins(VendingMachine machine, long coins) {
	    return false;
	}

	@Override
	public boolean selectItem(VendingMachine machine, String name) {
	    return false;
	}

	@Override
	public boolean takeItem(VendingMachine machine) {
	    return false;
	}

	@Override
	public boolean returnMoney(VendingMachine machine) {
	    return false;
	}

	@Override
	public boolean addItem(VendingMachine machine, String name, long price, int quantity) {
	    Item item = new Item(name, price);

	    return machine.getInventory().addItem(item, quantity);
	}

	@Override
	public boolean service(VendingMachine machine) {
	    return false;
	}

	@Override
	public boolean endService(VendingMachine machine) {
	    machine.setState(StateMachine.STAND_BY);
	    return false;
	}

    }
}
