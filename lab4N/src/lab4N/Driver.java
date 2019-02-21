package lab4N;

import lab4N.Canadian_VendingMachine;

public class Driver{
public static void main(String[] args) {
	//////////////////////////////////////////////////
	//Q0: Make sure that you are able to run the driver class and see the Vending Machine in action  
	Canadian_VendingMachine vm = new Canadian_VendingMachine(5, 2
			, "Water");
	// Enter the sufficient change 
	vm.Vend();
	// enter insufficient change 
	vm.Vend();
	// Q1: Make this VM vend Pepsi for you by changing above code 
	//////////////////////////////////////////////////
	//Q6: test out your canadian vending machine by editing the code above! 
	
}
}