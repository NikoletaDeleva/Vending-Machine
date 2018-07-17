package com.egtinteractive.vending_machine;

public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
	setName(name);
	setPrice(price);
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public double getPrice() {
	return this.price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

}
