package com.egtinteractive.vending_machine;

import java.math.BigDecimal;

public interface Machine {
    public abstract boolean putCoins(final VendingMachine machine, BigDecimal money);

    public abstract boolean selectItem(final VendingMachine machine, final String name);

    public abstract boolean takeItem(final VendingMachine machine);

    public abstract boolean service(final VendingMachine machine);

    public abstract boolean endService(final VendingMachine machine);

    public abstract boolean returnMoney(final VendingMachine machine);

    public abstract boolean addProduct(final VendingMachine machine, final String name, final long price,
	    final int quantity);

    public abstract boolean fixMachine(final VendingMachine machine);
}
