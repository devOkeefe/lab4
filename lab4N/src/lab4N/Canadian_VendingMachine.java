package lab4N;

import java.util.Arrays;
import java.util.Scanner;

import lab4N.VendingMachine;

public class Canadian_VendingMachine extends VendingMachine{
	
	// This class is an extension of VendingMachines  in Canada, in a US embassy.  

			public Canadian_VendingMachine(int x, double p, String type) {
		super(x, p, type);
		this.type = type;
		stuff = new String [x];
		Arrays.fill(stuff,this.type);
		price = p;
	}

			// Q5: Now, the original Vending Machine was made in US and all the currency was set to USD. 
			// But in Canada, we need to convert USD to CAD. 
			// %(a)One USD = 1.31 CAD, with conversion rate. write a getter and setter for it
			private double rate = 1.31;
			private String type;
			private double price;
			private String [] stuff;
			private double conv;
			private String currency;
			public double getConv() {
				return conv;
			}
			public void setConv(double conv) {
				this.conv=conv;
			}
			public double getrate(){
				// code here
				return rate;
			}
			public void setRate(double rate){
				// code here THIS IS CERTAIN
				this.rate=rate;
			}
			public String[] getStuff() {
				return stuff;
				}
			
			public void setStuff(String[] stuff) {
				this.stuff = stuff;
			}
			
			
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type=type;
			}
			
			public double getPrice() {
				return price;
			}
			public void setPrice(double price) {
				this.price=price;
			}
			
			// Here is what should happen: 
			//1. Price is displayed in USD and CAD both 
			//2. Customer gets a choice which currency to pay in 
			//3. Customer gets the change money in the currency he chose for 
			//4. The vending machine should always store the money in USD  
			// For this to happen, first ask customer which CurrencyIn they would like to pay. 
			// 5(c) Hence, override the currencyIn method 
			public String currencyIn(){
				//5(b)) this requires some getters! Write them first! 
				// correct the following line
				Scanner b = new Scanner(System.in);
				System.out.println("The price of a "+type+" is "+price+" USD");
				System.out.println("which is "+(price*rate)+ "CAD");
				System.out.println("How would you like to pay? USD or CAD? Please enter your response");
				String curr = b.next();
				this.currency = curr;
				return curr;
				
			}
			public double convertMoney() {
				
				String usd = "USD";
				String cad = "CAD";
				
				if (this.currency.equals(usd)) {
					this.conv = 1;
				}
				else if (this.currency.equals(cad)) {
					this.conv = 1.31;
				}
				return conv;
			}
			
			// Now, you will have to override the pay() method from parent 
			
			public double pay() {
				String curr = currencyIn();
				double convertedmoney = convertMoney();
				// 5(d)getMoneyFromCustomer() is a super class method. So edit the following line to call that
				double customerMoney = super.getMoneyFromCustomer();
				
				// get the price per bottle in the given country's currency. 
				// 5(e) edit the following line with getPrice, and exchange rate, and call exchangePrice from parent
				double unitprice = super.exchangePrice(curr,this.price, convertedmoney);
				// 5(f) getChangeis a super class method. So edit the following line to call that
				double change = super.getChange(unitprice, customerMoney);
				// if customer added insufficient money, the change would be the amount customer paid to, and in that case we don't want to wend anything
				if (change - customerMoney != 0.0){
					// yes, customer did give sufficient money
					//5(g)the price here should be in USD
					super.addVendingMachineMoney(this.price);
					return change;
				}
				return -1;
			}
			
			
			
			}





