package lab4N;
import java.util.Arrays;
import java.util.*;

public class VendingMachine {
///////////////////////////////////////////////////////////////////////////
	
private String type;
private String [] stuff;
private double machineMoney;
private double price;
private int capacity = 0;
///////////////////////////////////////////////////////////////////////////
// getters 
public int getCapacity() {
return capacity;
}
public double getMachineMoney() {
return machineMoney;
}
public double getPrice() {
return price;
}
public String[] getStuff() {
return stuff;
}
public String getType() {
return type;
}
///////////////////////////////////////////////////////////////////////////
//setters
protected void setCapacity(int capacity) {
this.capacity = capacity;
}
protected void setMachineMoney(double machineMoney) {
this.machineMoney = machineMoney;
}
protected void setPrice(double price) {
this.price = price;
}
public void setStuff(String[] stuff) {
this.stuff = stuff;
}
public void setType(String type) {
this.type = type;
}
///////////////////////////////////////////////////////////////////////////
public VendingMachine(int x, double p, String type) {
	this.type = type;
	stuff = new String [x];
	Arrays.fill(stuff,this.type);
	price = p;
}

///////////////////////////////////////////////////////////////////////
public int status() {
int stuff_at = -1;
for (int i = 0; i < stuff.length; i++) {
if(stuff[i]!=null) {
stuff_at = i;
}
}
return stuff_at;
}

/// The following methods are methods to help a machine transaction
public String currencyIn(){
System.out.println("The price of a "+type+" is "+price+" USD");
String curr = "USD";
return curr;
}
public double getMoneyFromCustomer(){
Scanner s = new Scanner(System.in);
System.out.println("Please enter your money");
double customerMoney = s.nextDouble();
return customerMoney;
}
public double getChange(double unitprice, double customerMoney){
double change = customerMoney;
if(customerMoney<unitprice) {
System.out.println("Insufficient amount. Please try again");
}else {
change = customerMoney - unitprice;
}
return change;
}
public void addVendingMachineMoney(double money){
this.machineMoney += money; 
}
public double exchangePrice(String curr, double priceUSD, double exchange_rate){
return priceUSD*exchange_rate;
}
public double pay() {
String curr = this.currencyIn();
double customerMoney = this.getMoneyFromCustomer();
 double unitprice = this.exchangePrice(curr, this.price, 1.0);
double change = this.getChange(unitprice, customerMoney);
if (change - customerMoney != 0.0){
this.addVendingMachineMoney(this.price);
return change;
}
return -1;
}

public void Vend() {
String product = null;
int at = this.status();
///////////////////////////////////////////////////////////////////////
if (at>=0) {
double change = this.pay();
if (change >=0) {
System.out.println("Your change is "+change);
product = stuff[at];
stuff[at] = null;
System.out.println(" Here is your one "+product);
System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
System.out.println("Have a great day!");
}
}
}
}




