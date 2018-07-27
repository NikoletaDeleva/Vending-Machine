package com.egtinteractive.inventory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Inventory {
    private final int SIZE;
    private Map<Item, Integer> products;

    public Inventory(int size) {
	this.products = new HashMap<Item, Integer>();
	this.SIZE = size;
    }

    public boolean addItem(final Item item, int quantity) {

	if (item == null) {
	    return false;
	}
	
	if (products.size() == SIZE && !products.containsKey(item)) {
	    return false;
	}
	
	String name = item.getName();

	for (Map.Entry<Item, Integer> product : products.entrySet()) {
	    if (product.getKey().getName().equals(name) && item.getPrice() != product.getKey().getPrice()) {
		return false;
	    }
	}

	Integer currentQuantity = products.get(item);
	
	if (quantity <= 0 || item.getPrice() <= 0) {
	    return false;
	}
	if (products.containsKey(item)) {
	    if (currentQuantity + quantity > 10) {
		products.replace(item, currentQuantity, 10);
	    } else {
		products.replace(item, currentQuantity, currentQuantity + quantity);
	    }
	} else {
	    products.put(item, quantity);
	}
	return true;
    }

    public boolean containsItem(final Item item) {
	return products.containsKey(item);
    }

    public int getAmountOfItem(final Item item) {
	return products.get(item);
    }

    public int getDifferentItemsCount() {
	return this.products.size();
    }

    public int getAllItemsCount() {
	int count = 0;
	for (Map.Entry<Item, Integer> item : products.entrySet()) {
	    count += item.getValue();
	}
	return count;
    }

    public void removeItem(final Item item) {
	products.remove(item);
    }

    public void getOneSpecificItemFromInventory(final Item item) {
	int currentQuantity = products.get(item);
	products.replace(item, currentQuantity, currentQuantity - 1);
    }

    public Item getItemByName(final String name) {
	for (Map.Entry<Item, Integer> item : products.entrySet()) {
	    if (item.getKey().getName().equals(name)) {
		return item.getKey();
	    }
	}
	return null;
    }

    public Map<Item, Integer> getProducts() {
	return Collections.unmodifiableMap(products);
    }

}
