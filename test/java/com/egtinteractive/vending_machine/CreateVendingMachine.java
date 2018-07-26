package com.egtinteractive.vending_machine;

import java.util.concurrent.ThreadLocalRandom;

import com.egtinteractive.vending_machine.VendingMachine;

public class CreateVendingMachine {

    private static void loadMachine(VendingMachine machine) {
	machine.service();
	final Items[] names = Items.values();

	for (int index = 0; index < Items.values().length; index++) {
	    machine.addItem(names[index].getName(), ThreadLocalRandom.current().nextLong(50, 500),
		    ThreadLocalRandom.current().nextInt(1, 10));
	}
	machine.endService();
    }

    public static VendingMachine createEmptyMachine() {
	VendingMachine machine = VendingMachine.getInstance();
	return machine;
    }

    public static VendingMachine createFullMachine() {
	VendingMachine machine = VendingMachine.getInstance();
	loadMachine(machine);
	return machine;
    }

    public static VendingMachine createFullMachineServiceMode() {
	VendingMachine machine = VendingMachine.getInstance();
	loadMachine(machine);
	machine.service();
	return machine;
    }

}
