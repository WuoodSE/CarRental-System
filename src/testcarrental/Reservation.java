package testcarrental;
import java.io.Serializable;
//this class represent a Reservation by customer
public class Reservation  implements Serializable {
private String fullName;
private String mobile;
private String ID;
private Car car;
private int numOfDays;
private double totalPrice;


public Reservation(String fullName, String mobile, String ID) {
this.fullName = fullName;
this.mobile = mobile;
this.ID = ID;
this.car = null;
this.numOfDays = 0;
this.totalPrice = 0;
}


// Copy constructor (copy of Reservation )
public Reservation(Reservation obj) { 
this.fullName = obj.fullName;
this.mobile = obj.mobile;
this.ID = obj.ID;
this.car = obj.car;
this.numOfDays = obj.numOfDays;
this.totalPrice = obj.totalPrice;
}


public String getId() {
return ID;
}


public String getPlateNo() {
if (car == null) {
return "";
}
else {
return car.getplateNo();
}
}



public double getTotalprice() {
return totalPrice;
}

//assigns a car to the reservaton
public void AssignCar(Car c, int days)throws ReservationException { 
if (c == null ) {
throw new ReservationException("This car doesnt exist");
}
if (days <= 0 ) {
throw new ReservationException("Number of days must be 1 or greater");
}
if (c.isAvailable()== false ) {
throw new ReservationException("This car is not avalianle");
}

this.car = c;
this.numOfDays = days;
c.setAvailable(false);
this.totalPrice = c.calculatePrice() * days;
}

    public String getFullName() {
        return fullName;
    }


    public String getMobile() {
        return mobile;
    }


    public String getID() {
        return ID;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getNumOfDays() {
        return numOfDays;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

// return the car
public void ReturnCar() {
if (car != null) {
car.setAvailable(true);
}
car = null;
numOfDays = 0;
totalPrice = 0;
}



public String toString() {
return " Reservation: " + " fullName: " + fullName + " mobile= " + mobile + " ID= " + ID + " Plate Number= " +getPlateNo() + " Number of Days= " + numOfDays +" Total Price= " + totalPrice;

}
}
