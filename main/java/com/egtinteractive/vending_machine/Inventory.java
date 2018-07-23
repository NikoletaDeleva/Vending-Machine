package com.egtinteractive.vending_machine;

import java.util.HashMap;
import java.util.Map;

public final class Inventory {
    private final int SIZE;
    private Map<Item, Integer> products;

    public Inventory(int size) {
	this.products = new HashMap<Item, Integer>();
	this.SIZE = size;
    }

    public boolean addItem(Item item, int quantity) {
	
	if(item == null) {
	    throw new NullPointerException("Null item! You cannot add it!");
	}
	if(quantity <= 0 || item.getPrice().doubleValue() <= 0) {
	    return false;
	}
	if(products.size() == SIZE) {
	    return false;
	}
	if(quantity > (this.SIZE - products.size())) {
	    quantity = this.SIZE - products.size();
	}
	if(products.containsKey(item)) {
	    int currentQuantity = products.get(item);
	    products.replace(item, currentQuantity, currentQuantity + quantity);
	}else {
	    products.put(item, quantity);
	}
	return true;
    }
    
    public boolean containsItem (Item item) {
	return products.containsKey(item);
    }
    
    public int getAmauntOfItem (Item item) {
	return products.get(item);
    }
    
    public void removeItem(Item item) {
	products.remove(item);
    }
    
    public void getOneSpecificItemFromInventory(Item item) {
	int currentQuantity = products.get(item);
	products.replace(item, currentQuantity ,currentQuantity - 1);
    }
    
}
