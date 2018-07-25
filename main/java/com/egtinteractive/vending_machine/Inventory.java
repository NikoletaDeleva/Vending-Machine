package com.egtinteractive.vending_machine;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public final class Inventory {
    private final int SIZE;
    private Map<Item, Integer> products;

    public Inventory(int size) {
	this.products = new HashMap<Item, Integer>();
	this.SIZE = size;
    }

    public boolean addItem(Item item, int quantity) {

	if (item == null) {
	    throw new NullPointerException("Null item! You cannot add it!");
	}

	int currentQuantity = products.get(item);

	if (products.size() == SIZE && !products.containsKey(item)) {
	    return false;
	}

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

    public boolean containsItem(Item item) {
	return products.containsKey(item);
    }

    public int getAmountOfItem(Item item) {
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

    public void removeItem(Item item) {
	products.remove(item);
    }

    public void getOneSpecificItemFromInventory(Item item) {
	int currentQuantity = products.get(item);
	products.replace(item, currentQuantity, currentQuantity - 1);
    }

    public Item getItemByName(String name) {
	for (Map.Entry<Item, Integer> item : products.entrySet()) {
	    if (item.getKey().getName().equals(name)) {
		return (Item) item;
	    }
	}
	throw new NoSuchElementException("There is no item with that name");
    }

}
