package com.egtinteractive.vending_machine;

public class DataProviderForVendingMachine {
    public static Object[][] getFullMachineDataProvider() {
	return new Object[][] { { CreateVendingMachine.createFullMachine() } };
    }

    public static Object[][] getFullMachineInServiceDataProvider() {
	return new Object[][] { { CreateVendingMachine.createFullMachineServiceMode() } };
    }

    public static Object[][] getEmptyMachineDataProvider() {
	return new Object[][] { { CreateVendingMachine.createEmptyMachine() } };
    }

    public static Object[][] getFullMachineWithMoneyAndSelectedProductDataProvider() {
	return new Object[][] { { CreateVendingMachine.createFullMachineWithMoney() } };
    }
}
