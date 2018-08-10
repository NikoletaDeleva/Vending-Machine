package com.egtinteractive.vending_machine;

import com.egtinteractive.inventory.Item;

public enum StateMachine implements Machine {
    STAND_BY {

	@Override
	public boolean putCoins(final VendingMachine machine, final long coins) {
	    if (coins <= 0) {
		return false;
	    }
	    machine.addCoinsToMachine(coins);
	    machine.setState(StateMachine.SELECT_ITEM);
	    return true;
	}

	@Override
	public boolean service(final VendingMachine machine) {
	    machine.setState(StateMachine.SERVICE);
	    return true;
	}

    },
    SELECT_ITEM {
	@Override
	public boolean putCoins(final VendingMachine machine, final long coins) {
	    machine.addCoinsToMachine(coins);
	    return true;
	}

	@Override
	public boolean selectItem(final VendingMachine machine, final String name) {

	    final Item specificItem = machine.getInventory().getItemByName(name);

	    if (specificItem == null) {
		return false;
	    }
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
	public boolean returnMoney(final VendingMachine machine) {
	    machine.returnCoinsToCustomer();
	    machine.setState(StateMachine.STAND_BY);
	    return true;
	}

	@Override
	public boolean service(final VendingMachine machine) {
	    machine.setState(StateMachine.SERVICE);
	    return true;
	}

    },
    TAKE_ITEM {

	@Override
	public boolean takeItem(final VendingMachine machine) {
	    if (machine.getCoins() > 0) {
		machine.returnCoinsToCustomer();
	    }
	    machine.setState(StateMachine.STAND_BY);
	    return true;
	}

	@Override
	public boolean service(final VendingMachine machine) {
	    machine.setState(StateMachine.SERVICE);
	    return true;
	}

    },
    SERVICE {

	@Override
	public boolean addItem(final VendingMachine machine, final String name, final long price, final int quantity) {
	    final Item item = new Item(name, price);

	    return machine.getInventory().addItem(item, quantity);
	}

	@Override
	public boolean endService(final VendingMachine machine) {
	    machine.setState(StateMachine.STAND_BY);
	    return true;
	}

    };

    @Override
    public boolean putCoins(final VendingMachine machine, long coins) {
	return false;
    }

    @Override
    public boolean selectItem(final VendingMachine machine, final String name) {
	return false;
    }

    @Override
    public boolean takeItem(VendingMachine machine) {
	return false;
    }

    @Override
    public boolean returnMoney(final VendingMachine machine) {
	return false;
    }

    @Override
    public boolean addItem(final VendingMachine machine, final String name, final long price, final int quantity) {
	return false;
    }

    @Override
    public boolean service(final VendingMachine machine) {
	return false;
    }

    @Override
    public boolean endService(final VendingMachine machine) {
	return false;
    }
}
