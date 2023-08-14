import java.io.Serializable;
import java.util.Objects;

public class ListStock implements Serializable {
    private NodeStock head;
    private int numItems;
    public ListStock() {
        numItems = 0;
        head = null;
    }
    public boolean isEmpty(){
        return numItems==0;//false or true
    }
    public int size(){
        return numItems;
    }
    private NodeStock find(int index) {
        NodeStock curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }
    public NodeStock find(String title){
        NodeStock curr = head;
        while(curr.next != null){
            if(curr.item.getTitle().compareTo(title) == 0 ){
                return curr;
            }
            else{
                curr = curr.next;
            }
        }
        return curr;
    }

    public NodeStock find(StockItem item){
        NodeStock curr = head;
        while (curr.next != null) {
            if(Objects.equals(curr.item.getTitle(), item)){
                return curr;
            }
            else{
                curr = curr.next;
            }
        }
        return null;
    }
    public StockItem get(int index) throws ListIndexOutOfBoundsException {
        if (index >= 0 && index < numItems) {
            NodeStock curr = find(index);
            StockItem dataItem = curr.item;
            return dataItem;
        }
        else {
            throw new ListIndexOutOfBoundsException(
            "List index out of bounds on get");
        }
    }
    public void add(StockItem item){
        if(head == null){
            head = new NodeStock(item);
        }
        else{
            NodeStock curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = new NodeStock(item);
        }
    }

    //adds to index of list
    public void add(int index, StockItem item) throws ListIndexOutOfBoundsException {
        if (index >= 0 && index < numItems+1) {
            if (index == 0) {
                NodeStock newNode = new NodeStock(item, head);
                head = newNode;
                //adds new head if adding to index 0
            }
            else {
                NodeStock prev = find(index-1);
                NodeStock newNode = new NodeStock(item, prev.next);
                prev.next = newNode;
                //
            }
            numItems++;
        }
        else {
            throw new ListIndexOutOfBoundsException(
            "List index out of bounds on add");
        }
    }

    //removes item at given index;
    public void remove(int index) throws ListIndexOutOfBoundsException {
        if (index >= 0 && index < numItems) {
            if (index == 0) {
                head = head.next;
            }
            else {
                NodeStock prev = find(index-1);
                NodeStock curr = prev.next;
                prev.next = curr.next;
            }
            numItems--;
        }
        else {
            throw new ListIndexOutOfBoundsException("List index out of bounds on remove");
        } 
    }
    public void printAll(){
        NodeStock curr = head;
        while(curr.next != null){
            StockItem item = curr.item;
            System.out.println(item.toString());
            curr = curr.next;
        }
        System.out.println(curr.item.toString());
    }
    public void removeAll() {
        head = null;
        numItems = 0;
    }
}
