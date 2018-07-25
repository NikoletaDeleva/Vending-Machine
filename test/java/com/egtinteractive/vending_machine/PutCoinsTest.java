package com.egtinteractive.vending_machine;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PutCoinsTest {

    @DataProvider(name = "getFullMachine")
    public Object[][] getData() {
	return DataProviderForVendingMachine.getFullMachineDataProvider();
    }

    @Test(dataProvider = "getFullMachine")
    public void putCoinsTest(VendingMachine machine) {
	long expected = 0l;
	final int count = ThreadLocalRandom.current().nextInt(1, 100);

	for (int index = 0; index < count; index++) {
	    long amount = ThreadLocalRandom.current().nextLong(500, 1000);
	    machine.putCoins(amount);
	    expected += amount;
	}

	final long actual = machine.getCoins();

	assertEquals(actual, expected);
    }

    @Test(dataProvider = "getFullMachine")
    public void addCoinsTestIfInvalid(final VendingMachine machine) {

	final long expected = ThreadLocalRandom.current().nextLong(1, 100);
	final long coinsInMachine = machine.putCoins(expected);

	assertEquals(coinsInMachine, expected);

	final long invalidAmount = ThreadLocalRandom.current().nextLong(-100, 0);
	final long actual = machine.putCoins(invalidAmount);

	assertEquals(actual, expected);
    }

    @Test(dataProvider = "getFullMachine")
    public void putCoins(VendingMachine machine) {
	final int coinsToPut = ThreadLocalRandom.current().nextInt(100, 500);
	machine.putCoins(coinsToPut);

	final long actual = machine.getCoins();

	assertEquals(actual, coinsToPut);

    }
}
