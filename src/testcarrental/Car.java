package testcarrental;
import java.io.Serializable;

public abstract class Car implements Serializable {
   private String plateNo; //car plate number
   private boolean available; //if the car is available or not for rent
   protected double pricePerDay; //price per day for renting the car

//constructor (initialize car with plate and price
   public Car(String plateNo, double pricePerDay) {
      this.plateNo = plateNo;
      this.pricePerDay = pricePerDay;
      this.available = true;
   }
   
   public String getplateNo() {
      return plateNo;
   }

//checks if the car is available
   public boolean isAvailable() { 
      return available;
   }

// check setAvailability
   public void setAvailable(boolean available) { 
   
      this.available = available;
   }


   public double getPricePerDay() {
      return pricePerDay;
   }


   public void setPricePerDay(double pricePerDay) {
      this.pricePerDay = pricePerDay;
   }

//abstract method (polymorphism each subclass implement diffrently)
   public abstract double calculatePrice(); 

   public String toString() {
      return " plateNo= " + plateNo + " available= " +
         available + " pricePerDay= "+pricePerDay;
   }

}
