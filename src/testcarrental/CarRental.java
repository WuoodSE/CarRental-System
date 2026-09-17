
package testcarrental;
import java.io.* ;
public class CarRental {
private String rentalName;
Node MainCar ;
ReservationNode MainReservation ; 
private int MaxCars =200;
private int MaxRes =200;
public CarRental(String name) {
this.rentalName = name;
MainCar= null;
MainReservation= null ;

}

public int CountCar(){
int count =0 ;
Node current= MainCar;
while( current !=null){
    count++;
    current=current.getNext();
}
  return count ;   
    
}
public int CountReservation(){
int count =0 ;
ReservationNode current= MainReservation;
while( current !=null){
    count++;
current=current.getNext();
}
  return count ;   
    
}
          
        
        
        
public boolean addCar(Car c) { //add new car
if (c == null) {
return false;
}
if (CountCar() < MaxCars) {
Node nod = new Node (c);
nod.setNext(MainCar);
MainCar=nod ;
return true ; 
}
return false;
}
public boolean addReservation(Reservation r) { 
if (r == null ) {
return false;
}
        if (CountReservation() < MaxRes) { // composition
            ReservationNode n = new ReservationNode(new Reservation(r));
            n.setNext(MainReservation);
            MainReservation = n;
            return true;
        }
        return false;
    }
public boolean cancelReservation(String id , String plateNo) {
if (MainReservation == null) {
return false;
        }

        if (MainReservation.getData().getID().equalsIgnoreCase(id)&& MainReservation.getData().getPlateNo().equalsIgnoreCase(plateNo)) {
 MainReservation.getData().ReturnCar();
MainReservation = MainReservation.getNext();
return true;
        }

        ReservationNode priv = MainReservation;
        ReservationNode current = MainReservation.getNext();

        while (current != null) {
            if (current.getData().getID().equalsIgnoreCase(id) && current.getData().getPlateNo().equalsIgnoreCase(plateNo)) {
                current.getData().ReturnCar();
                priv.setNext(current.getNext());
                return true;
            }
            priv = current;
            current = current.getNext();
        }

        return false;
    }
public Reservation searchReservation(String id , String 
plateNo){// search Reservation
ReservationNode current = MainReservation;
        while (current != null) {
            if (current.getData().getID().equalsIgnoreCase(id) && current.getData().getPlateNo().equalsIgnoreCase(plateNo)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
public Car searchCar(String plate) {// search Car
Node current = MainCar;
        while (current != null) {
            if (current.getData().getplateNo().equalsIgnoreCase(plate)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
public String getEconomyRecursiveText() {
        String text = getEconomyRecursiveText(MainCar);
        if (text.equals("")) {
            return "No economy cars.";
        }
        return text;
    }

    private String getEconomyRecursiveText(Node current) {
        if (current == null) {
            return "";
        }
        String text = "";
        if (current.getData() instanceof EconomyCar) {
            text += current.getData().toString() + "\n";
        }
        return text + getEconomyRecursiveText(current.getNext());
    }
public String getRentalName() {
return rentalName;
}
public String getAllReservations() {
String text = "";
        ReservationNode current = MainReservation;
        while (current != null) {
            text += current.getData().toString() + "\n----------\n";
            current = current.getNext();
        }
        return text.isEmpty() ? "No Reservations Found." : text;
    }
public String viewAvailableCars() {// view Available Cars
boolean found = false;
    Node current = MainCar;
String text = "";

    while (current != null) {
        Car c = current.getData();

        if (c != null && c.isAvailable()) {
            text += c.toString() + "\n----------\n";
            found = true;
        }

        current = current.getNext();
    }

    if (!found) {
        return "No available cars" ;
    }
return text ;
}
public boolean hasReservation(String id) {
ReservationNode current = MainReservation;
        while (current != null) {
            if (current.getData().getID().equalsIgnoreCase(id)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void saveAllInfo() throws IOException {
        File out = new File("Cars.dat");
        FileOutputStream fos = new FileOutputStream(out);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(MainCar);
        oos.close();

        File out2 = new File("Reservations.dat");
        FileOutputStream fos2 = new FileOutputStream(out2);
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
        oos2.writeObject(MainReservation);
        oos2.close();
    }

    
    public void readAllData() throws IOException, ClassNotFoundException {
        File f = new File("Cars.dat");
        FileInputStream ff = new FileInputStream(f);
        ObjectInputStream in = new ObjectInputStream(ff);
        MainCar = (Node) in.readObject();
        in.close();

        File f2 = new File("Reservations.dat");
        FileInputStream ff2 = new FileInputStream(f2);
        ObjectInputStream in2 = new ObjectInputStream(ff2);
        MainReservation = (ReservationNode) in2.readObject();
        in2.close();

        reconnectReservationCars();
    }

    private void reconnectReservationCars() {
        Node carCurrent = MainCar;
        while (carCurrent != null) {
            carCurrent.getData().setAvailable(true);
            carCurrent = carCurrent.getNext();
        }

        ReservationNode resCurrent = MainReservation;
        while (resCurrent != null) {
            String plate = resCurrent.getData().getPlateNo();
            Car realCar = searchCar(plate);
            if (realCar != null) {
                resCurrent.getData().setCar(realCar);
                realCar.setAvailable(false);
            }
            resCurrent = resCurrent.getNext();
        }
    }

    void savaAllInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String viewAllReservations() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
