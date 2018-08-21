package mainDemo;

import com.egtinteractive.inventory.Inventory;
import com.egtinteractive.io.ConsoleIO;
import com.egtinteractive.io.IO;
import com.egtinteractive.vending_machine.Machine;
import com.egtinteractive.vending_machine.VendingMachine;

public class Demo {
    public static void main(String[] args) {
	IO io = new ConsoleIO();
	VendingMachine machine = new VendingMachine(io, new Inventory(16));
	
	((ConsoleIO) io).listAllItems(machine.listItems());
	machine.service();
	machine.addItem("Kola", 100, 10);
	machine.addItem("Chips", 50, 7);
	machine.endService();
	((ConsoleIO) io).listAllItems(machine.listItems());
	machine.putCoins(10);
	((ConsoleIO) io).listAllItems(machine.listItems());
	machine.selectItem("Kola");
    }
}
