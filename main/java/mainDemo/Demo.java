package mainDemo;

import com.egtinteractive.vending_machine.VendingMachine;

public class Demo {
    public static void main(String[] args) {
	VendingMachine machine = VendingMachine.getInstance(16);
	machine.loadHomePage();
	machine.service();
	machine.addItem("Sok 1" , 300, 5);
	machine.addItem("Sok 1" , 300, 5);
	machine.endService();
	machine.putCoins(200);
	machine.selectItem("Sok 1");
	machine.loadHomePage();
    }
}
