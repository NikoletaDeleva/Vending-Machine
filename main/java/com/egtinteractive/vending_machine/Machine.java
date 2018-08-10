package com.egtinteractive.vending_machine;

public interface Machine {
    public abstract boolean putCoins(final VendingMachine machine, final long money);

    public abstract boolean selectItem(final VendingMachine machine, final String name);

    public abstract boolean takeItem(final VendingMachine machine);

    public abstract boolean service(final VendingMachine machine);

    public abstract boolean endService(final VendingMachine machine);

    public abstract boolean returnMoney(final VendingMachine machine);

    public abstract boolean addItem(final VendingMachine machine, final String name, final long price,
	    final int quantity);
}
