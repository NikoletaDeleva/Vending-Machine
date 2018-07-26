package com.egtinteractive.vending_machine;

public class DataProviderForVendingMachine {
    public static Object[][] getFullMachine() {
	return new Object[][] { { CreateVendingMachine.createFullMachine() } };
    }

    public static Object[][] getFullMachineInService() {
	return new Object[][] { { CreateVendingMachine.createFullMachineServiceMode() } };
    }

    public static Object[][] getEmptyMachine() {
	return new Object[][] { { CreateVendingMachine.createEmptyMachine() } };
    }

}
