
package testcarrental;
import java.io.Serializable ; 
public class Node implements Serializable  {
    private Car data ;
    private Node next ;
    
    public Node (Car obj){
      data=obj ; 
      next=null ;
            
    }

    public Car getData() {
        return data;
    }

    public void setData(Car obj) {
        data = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextptr) {
       next = nextptr;
    }
   
}
