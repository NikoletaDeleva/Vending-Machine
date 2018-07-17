package com.egtinteractive.vending_machine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Machine state;
    private Map<Item,Integer> products;
    private Item currentItem;
    
    public VendingMachine() {
	this.state = Machine.STAND_BY;
	this.products = new HashMap<Item, Integer>();
	currentItem = null;
    }
    
    
    public boolean takeMoney() {
	 
	return true;
    }


    public void setState(Machine state) {
	this.state = state; 
    }
}
