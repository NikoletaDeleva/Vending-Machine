package com.egtinteractive.vending_machine;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    private String name;
    private BigDecimal price;

    public Item(String name, BigDecimal price) {
	this.name = name;
	this.price = price;
    }

    public String getName() {
	return this.name;
    }

    public BigDecimal getPrice() {
	return this.price;
    }

    @Override
    public int hashCode() {

	return 7*Objects.hashCode(name) + 11*Objects.hashCode(price);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (!(obj instanceof Item)) {
	    return false;
	}
	
	Item other = (Item) obj;
	
	return name.equals(other.name) && price.equals(other.price);
    }

}
