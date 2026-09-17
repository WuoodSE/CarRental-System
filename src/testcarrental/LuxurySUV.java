package testcarrental;
//this class represent an luxury SUV car type
public class LuxurySUV extends SUV implements Services {
private boolean vipPackage;



public LuxurySUV(String plateNo, double pricePerDay,boolean fullPackage,boolean vipPackage)
{
super(plateNo, pricePerDay, fullPackage);
this.vipPackage = vipPackage;
}

// check if the user choose vip Package
@Override
public int getServices() {
if (vipPackage == true) {
return 4;
}

else {
return 2;
}
}


@Override
public double calculatePrice() {
double suvPart = super.calculatePrice();
double vipAdd;
if (vipPackage == true) {
vipAdd = 80;
}
else {
vipAdd = 0;
}
return suvPart + vipAdd + (getServices() * 15);
}


public String toString() {
return " Luxury SUV Car: plateNO= " + getplateNo()+"price per day "+getPricePerDay()+"full package"+getfullPackage()+ " VIP Package: " + vipPackage + "Services: " + getServices() + " Final Price: " +calculatePrice();

}
}