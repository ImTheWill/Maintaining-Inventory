import java.io.Serializable;
import java.lang.*;
public class Customer implements Serializable {
    String first;
    String last;
    String number;
    Customer(String first, String last, String num){
        this.first = first;
        this.last  = last;
        this.number = num;

    }

    @Override
    public String toString() {
        return this.first + "\n" + this.last + "\n" + this.number;
    }
}
