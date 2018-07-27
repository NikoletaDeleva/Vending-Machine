package com.egtinteractive.data_provider;

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

    public static Object[][] getFullMachineItemSelectedtDataProvider() {
	return new Object[][] { { CreateVendingMachine.createFullMachineItemSelected() } };

    }

}
