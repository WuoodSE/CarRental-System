package testcarrental;
//this method represent an SUV car type
public class SUV extends Car {
protected boolean fullPackage;


public SUV(String plateNo, double pricePerDay, boolean
fullPackage) {
super(plateNo, pricePerDay);
this.fullPackage = fullPackage;
}


//calculate rental cost with full Package or without it
public double calculatePrice() { 

if (fullPackage == true) {
return pricePerDay + 40;
}
else {
return pricePerDay + 20;
}
}
public boolean getfullPackage(){
return fullPackage;
}
public String toString() {
return " SUV Car : " +super.toString() + " has a fullPackage : " + fullPackage;

}
}