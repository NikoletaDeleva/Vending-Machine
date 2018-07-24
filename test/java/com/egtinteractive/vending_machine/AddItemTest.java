package com.egtinteractive.vending_machine;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddItemTest {

    @DataProvider(name = "getFullMachineInService")
    public Object[][] getData() {
	return DataProviderForVendingMachine.getFullMachineInServiceDataProvider();
    }

    @Test(dataProvider = " ")
    public void f() {
    }
}
