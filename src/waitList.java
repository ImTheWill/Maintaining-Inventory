import java.util.*;
public class waitList {
    private  LinkedList<Customer> waitList = new LinkedList<>();
    private  int posInWait = 0;

    public String add(Customer cust){
        waitList.add(cust);
        this.posInWait++;

        return "Position in wait list: " + posInWait;
    }

    //might need to be string to increase interactivity between other classes
    public  void remove(){
        waitList.removeFirst();//removes first customer from the waitList;

    }


}
