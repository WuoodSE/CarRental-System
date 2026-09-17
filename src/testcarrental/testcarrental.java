package testcarrental;
import java.io.File; 
import javax.swing.JOptionPane;
public class testcarrental {
public static CarRental rental = new CarRental("KSU Car Rental");

    public static void main(String[] args) {
        File carFile = new File("Cars.dat");
        File reservationFile = new File("Reservations.dat");

        if (carFile.exists() && reservationFile.exists()) {
            try {
                rental.readAllData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Saved data could not be loaded, so initial cars will be added.\n" + ex.getMessage());
                addInitialCars();
            }
        } else {
            addInitialCars();
        }

        new FaceFrame(rental).setVisible(true);
    }
    private static void addInitialCars() {
        rental.addCar(new EconomyCar("ABC-111", 150, "Petrol"));
        rental.addCar(new EconomyCar("DCA-121", 120, "Diesel"));
        rental.addCar(new EconomyCar("MBA-333", 70, "Diesel"));

        rental.addCar(new SUV("SUV-222", 200, true));
        rental.addCar(new SUV("SUV-111", 120, true));
        rental.addCar(new SUV("SUV-444", 90, false));

        rental.addCar(new LuxurySUV("LUX-333", 400, true, true));
        rental.addCar(new LuxurySUV("LUX-686", 300, false, true));
        rental.addCar(new LuxurySUV("LUX-999", 500, true, false));
    }
}
