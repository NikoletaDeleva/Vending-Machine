package com.egtinteractive.vending_machine;

public class CreateVendingMachine {

    public static VendingMachine createEmptyMachine() {
	VendingMachine machine = VendingMachine.getInstance();
	return machine;
    }

    public static VendingMachine createFullMachine() {
	//
	VendingMachine machine = VendingMachine.getInstance();
	return machine;
    }

    public static VendingMachine createFullMachineWithMoney() {
	return null;
    }

    public static VendingMachine createFullMachineServiceMode() {

	return null;
    }

}
