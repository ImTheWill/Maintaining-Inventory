import java.io.Serializable;

public class ListReferenceBased implements ListInterface, Serializable {
    private Node head;
    private int numItems;
    public ListReferenceBased() {
        numItems = 0;
        head = null;
    }
    public boolean isEmpty(){
        return numItems==0;//false or true
    }
    public int size(){
        return numItems;
    }
    private Node find(int index) {
        Node curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }
    public Node find(Object obj){
        Node curr = head;
        while (curr.next != null) {
            if(curr.item == obj){
                return curr;
            }
            else{
                curr = curr.next;
            }
        }
        return null;
    }
    public Object get(int index) throws ListIndexOutOfBoundsException {
        if (index >= 0 && index < numItems) {
            Node curr = find(index);
            Object dataItem = curr.item;
            return dataItem;
        }
        else {
            throw new ListIndexOutOfBoundsException(
            "List index out of bounds on get");
        }
    }

    //adds to end of list
    public void add(Object item){
        Node new_node = new Node(item);

        if (head == null) {
            head = new Node(item);
            numItems++;
            return;
        }
        new_node.next = null;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
        numItems++;
    }

    //adds to index of list
    public void add(int index, Object item) throws ListIndexOutOfBoundsException {
        if (index >= 0 && index < numItems+1) {
            if (index == 0) {
                Node newNode = new Node(item, head);
                head = newNode;
                //adds new head if adding to index 0
            }
            else {
                Node prev = find(index-1);
                Node newNode = new Node(item, prev.next);
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
                Node prev = find(index-1);
                Node curr = prev.next;
                prev.next = curr.next;
            }
            numItems--;
        }
        else {
            throw new ListIndexOutOfBoundsException("List index out of bounds on remove");
        } 
    }
    public void removeAll() {
        head = null;
        numItems = 0;
    }
    public void printAll(){
        Node curr = head;
        while(curr.next != null){
            Object item = curr.item;
            System.out.println(item.toString());
            curr = curr.next;
        }
        System.out.println(curr.item.toString());
    }
}
