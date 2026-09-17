package testcarrental;
//this class represent an economy car type
public class EconomyCar extends Car implements Services {
private String fuelType;


public EconomyCar(String plateNo, double pricePerDay,
String fuelType) {
super(plateNo, pricePerDay);
this.fuelType = fuelType;
}


@Override
public int getServices() {
if ("Petrol".equalsIgnoreCase(fuelType)) {
return 2;
}
else {
return 1;
}
}


//calculate total price based on fuel type
@Override
public double calculatePrice() { 

if ("Petrol".equalsIgnoreCase(fuelType)) {
return pricePerDay + (getServices() * 20.0);
}
else {
return pricePerDay+10;
}
}


@Override
public String toString() {
return " Economy Car: " + super.toString() + " fuelType:" + fuelType + " services: " + getServices() + " finalPrice= " + calculatePrice();


}
}
