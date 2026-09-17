package testcarrental;
import java.io.Serializable ;
public class ReservationNode implements Serializable{
    private Reservation data;
    private ReservationNode next;

    public ReservationNode(Reservation obj) {
        data = obj;
        next = null;
    }

    public void setNext(ReservationNode nextPtr) {
        next = nextPtr;
    }

    public ReservationNode getNext() {
        return next;
    }

    public void setData(Reservation obj) {
        data = obj;
    }

    public Reservation getData() {
        return data;
    }
}
