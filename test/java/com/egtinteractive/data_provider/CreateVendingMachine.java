package com.egtinteractive.data_provider;

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
	VendingMachine machine = VendingMachine.getInstance(16);
	return machine;
    }

    public static VendingMachine createFullMachine() {
	VendingMachine machine = VendingMachine.getInstance(16);
	loadMachine(machine);
	return machine;
    }

    public static VendingMachine createFullMachineServiceMode() {
	VendingMachine machine = VendingMachine.getInstance(16);
	loadMachine(machine);
	machine.service();
	return machine;
    }

    public static Object createFullMachineItemSelected() {
	VendingMachine machine = VendingMachine.getInstance(16);
	loadMachine(machine);
	machine.putCoins(ThreadLocalRandom.current().nextLong(50, 500));

	final String item = Items.values()[ThreadLocalRandom.current().nextInt(Items.values().length)].getName();
	machine.selectItem(item);
	return machine;
    }

}
