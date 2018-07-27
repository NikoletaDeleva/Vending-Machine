package com.egtinteractive.vending_machine;

import static org.testng.Assert.assertFalse;

import java.util.UUID;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.egtinteractive.vending_machine.VendingMachine;
import com.egtinteractive.data_provider.DataProviderForVendingMachine;

public class SelectItemTest {

    @DataProvider(name = "getFullMachine")
    public Object[][] getData() {
	return DataProviderForVendingMachine.getFullMachine();
    }

    @Test(dataProvider = "getFullMachine")
    public void machineWithoutCoins(VendingMachine machine) {
	assertFalse(machine.takeItem());
    }

    @Test(dataProvider = "getFullMachine")
    public void machineShouldNotLetYouAddProductsWhileItsWorking(final VendingMachine machine) {
	assertFalse(machine.addItem(UUID.randomUUID().toString(), 10L, 1));
    }
}
