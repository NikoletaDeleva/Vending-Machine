package com.egtinteractive.vending_machine;

import static org.testng.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.egtinteractive.data_provider.DataProviderForVendingMachine;

public class TakeItemTest {
    @DataProvider(name = "getFullMachineItemSelected")
    public Object[][] getData() {
	return DataProviderForVendingMachine.getFullMachineItemSelectedtDataProvider();
    }

    @Test(dataProvider = "getFullMachineItemSelected")
    public void takeItemAndChangeStateToStandBy(final VendingMachine machine) {
	String name = UUID.randomUUID().toString();
	machine.takeItem();
	final long cost = ThreadLocalRandom.current().nextLong(500, 1000);
	machine.service();
	assertTrue(machine.addItem(name, cost, 1));
	assertTrue(machine.endService());
	machine.putCoins(cost);

	machine.selectItem(name);
	assertTrue(machine.takeItem());

	assertTrue(machine.getState() == StateMachine.STAND_BY);
    }

}
