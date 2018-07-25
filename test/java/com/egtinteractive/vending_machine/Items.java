package com.egtinteractive.vending_machine;

public enum Items {
    KITKAT("KitKat"), LOLLIPOP("LolliPop"), FANTA("Fanta"), Mura("Mura"), JUICE("Juice"), WATER("Water");

    private final String name;

    Items(final String name) {
	this.name = name;
    }

    public String getName() {
	return this.name;
    }
}
