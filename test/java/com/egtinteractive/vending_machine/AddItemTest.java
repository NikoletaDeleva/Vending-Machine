package com.egtinteractive.vending_machine;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddItemTest {

    @DataProvider(name = "getFullMachineInService")
    public Object[][] getData() {
	return DataProviderForVendingMachine.getFullMachineInServiceDataProvider();
    }

    @Test(dataProvider = "getFullMachineInService")
    public void addNonExistingItem(VendingMachine machine) {
	final int beforeSize = machine.getDifferentItemsCount();
	final int beforeAmountOfAll = machine.getAllItemsCount();

	final int itemsToPut = ThreadLocalRandom.current().nextInt(1, 10);

	machine.addItem("Kola", 180, itemsToPut);

	final int afterSize = machine.getDifferentItemsCount();
	final int afterAmountOfAll = machine.getAllItemsCount();

	assertEquals(afterSize, beforeSize + 1);
	assertEquals(afterAmountOfAll, beforeAmountOfAll + itemsToPut);
    }

    @Test(dataProvider = "getFullMachineInService")
    public void addProductWithNegativePrice(VendingMachine machine) {
	assertFalse(machine.addItem("Duvki", -100, 5));
    }

    @Test(dataProvider = "getFullMachineInService")
    public void addProductWithNegativeAmount(VendingMachine machine) {
	assertFalse(machine.addItem("Duvki", 100, -5));
    }

}
