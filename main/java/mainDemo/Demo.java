package mainDemo;

import com.egtinteractive.vending_machine.VendingMachine;

public class Demo {
    public static void main(String[] args) {
	VendingMachine machine = VendingMachine.getInstance();
	machine.loadHomePage();
	machine.service();
	machine.addItem("Sok 1" , 300, 5);
	machine.addItem("Sok 1" , 300, 5);
	machine.endService();
	machine.loadHomePage();
	machine.putCoins(500);
	machine.loadHomePage();
	machine.selectItem("Sok 1");
	machine.loadHomePage();
	System.out.println(machine.service());
	machine.loadHomePage();
	
    }
}
