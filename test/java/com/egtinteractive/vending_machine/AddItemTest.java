package com.egtinteractive.vending_machine;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.egtinteractive.data_provider.DataProviderForVendingMachine;
import com.egtinteractive.vending_machine.VendingMachine;

public class AddItemTest {

    @DataProvider(name = "getFullMachineInService")
    public Object[][] getData() {
	return DataProviderForVendingMachine.getFullMachineInService();
    }

    @Test(dataProvider = "getFullMachineInService")
    public void addNonExistingItem(final VendingMachine machine) {
	final int beforeSize = machine.getDifferentItemsCount();
	final int beforeAmountOfAll = machine.getAllItemsCount();

	final int itemsToPut = ThreadLocalRandom.current().nextInt(1, 10);

	machine.addItem(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextLong(50,500), itemsToPut);

	final int afterSize = machine.getDifferentItemsCount();
	final int afterAmountOfAll = machine.getAllItemsCount();

	assertEquals(afterSize, beforeSize + 1);
	assertEquals(afterAmountOfAll, beforeAmountOfAll + itemsToPut);
    }

    @Test(dataProvider = "getFullMachineInService")
    public void addProductWithNegativePrice(final VendingMachine machine) {
	assertFalse(machine.addItem(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextLong(-100, 0),
		ThreadLocalRandom.current().nextInt(1, 10)));
    }

    @Test(dataProvider = "getFullMachineInService")
    public void addProductWithNegativeAmount(final VendingMachine machine) {
	assertFalse(machine.addItem(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextLong(0, 500),
		ThreadLocalRandom.current().nextInt(-10, 0)));
    }

}
