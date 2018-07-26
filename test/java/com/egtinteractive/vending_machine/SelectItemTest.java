package com.egtinteractive.vending_machine;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.egtinteractive.vending_machine.Item;
import com.egtinteractive.vending_machine.VendingMachine;
import com.egtinteractive.vending_machine.DataProviderForVendingMachine;
import com.egtinteractive.vending_machine.Items;

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
    public void machine(VendingMachine machine) {
	machine.putCoins(ThreadLocalRandom.current().nextLong(50,500));
	final String itemName = Items.values()[ThreadLocalRandom.current()
		.nextInt(Items.values().length)].getName();

	final int expectedQuantity = machine.getSpecificItemCount(itemName) - 1;

	final Item item = machine.selectItem(itemName);
	assertNotNull(item);
	final int actualQuantity = machine.getSpecificItemCount(itemName);

	assertEquals(actualQuantity, expectedQuantity);
    }
    
    @Test(dataProvider = "getFullMachine")
    public void machineShouldSelectItemAndThenTakeTheMoneyForIt(final VendingMachine machine) {
	machine.putCoins(ThreadLocalRandom.current().nextLong(50,500));
	
	long moneyLeft = machine.getCoins();
	
	final String item = Items.values()[ThreadLocalRandom.current()
		.nextInt(Items.values().length)].getName();
	machine.selectItem(item);
	moneyLeft -= machine.getItemPrice(item);
	final long coins = machine.getCoins();

	assertEquals(coins, moneyLeft);
    }
    
    @Test(dataProvider = "getFullMachine")
    public void machineShouldNotLetYouAddProductsWhileItsWorking(final VendingMachine machine) {
	assertFalse(machine.addItem(UUID.randomUUID().toString(), 10L, 1));
    }
}
