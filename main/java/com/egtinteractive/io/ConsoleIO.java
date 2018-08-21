package com.egtinteractive.io;

import java.util.List;
import java.util.Scanner;

import com.egtinteractive.inventory.Item;

public class ConsoleIO implements IO {
    private final Scanner scanner;

    public ConsoleIO() {
	this.scanner = new Scanner(System.in);
    }

    @Override
    public void write(final String str) {
	System.out.println(str);

    }

    @Override
    public String read() {
	return scanner.nextLine();
    }

    @Override
    public void close() throws Exception {
	scanner.close();

    }

    public void listAllItems(List<Item> listItems) {

	if (listItems.size() <= 0) {

	    this.write("Machine need service!");

	} else {
	    for (Item item : listItems) {
		this.write(item.toString());
	    }

	    this.write(System.lineSeparator());
	}
    }
}
