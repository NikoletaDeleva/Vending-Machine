package com.egtinteractive.vending_machine;

public interface IMachine {
    abstract boolean putCoins(final VendingMachine machine, final long coins);

    abstract boolean selectItem(final VendingMachine machine, final String name);

    abstract boolean takeItem(final VendingMachine machine);

    abstract boolean service(final VendingMachine machine);

    abstract boolean endService(final VendingMachine machine);

    abstract boolean returnMoney(final VendingMachine machine);

    abstract boolean addProduct(final VendingMachine machine, final String name, final long price, final int quantity);

    abstract boolean fixMachine(final VendingMachine machine);
}
