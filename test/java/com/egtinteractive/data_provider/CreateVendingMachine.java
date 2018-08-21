package com.egtinteractive.data_provider;

import java.util.concurrent.ThreadLocalRandom;

import com.egtinteractive.inventory.Inventory;
import com.egtinteractive.io.ConsoleIO;
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
	final int size = 16;
	ConsoleIO io = new ConsoleIO();
	VendingMachine machine = new VendingMachine(io, new Inventory(size));
	return machine;
    }

    public static VendingMachine createFullMachine() {
	final int size = 16;
	ConsoleIO io = new ConsoleIO();
	VendingMachine machine = new VendingMachine(io, new Inventory(size));
	loadMachine(machine);
	return machine;
    }

    public static VendingMachine createFullMachineServiceMode() {
	final int size = 16;
	ConsoleIO io = new ConsoleIO();
	VendingMachine machine = new VendingMachine(io, new Inventory(size));
	loadMachine(machine);
	machine.service();
	return machine;
    }

    public static Object createFullMachineItemSelected() {
	final int size = 16;
	ConsoleIO io = new ConsoleIO();
	VendingMachine machine = new VendingMachine(io, new Inventory(size));
	loadMachine(machine);
	machine.putCoins(ThreadLocalRandom.current().nextLong(50, 500));

	final String item = Items.values()[ThreadLocalRandom.current().nextInt(Items.values().length)].getName();
	machine.selectItem(item);
	return machine;
    }

}
