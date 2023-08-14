import java.io.Serializable;

public class StockItem implements java.lang.Comparable, Serializable {
    private String title;
    private int have, want;
    private ListReferenceBased waitingList = new ListReferenceBased();

    public StockItem(String title, int want, int have){
        this.title = title;
        this.have = have;
        this.want = want;
    }

    //adding person to wait-list
    public void addToWaitingList(String lastName,String firstName, String phone){
        waitingList.add(new Customer(lastName, firstName, phone));
        this.want++;
    }
    public void removeFromWaitList(){
        waitingList.remove(0);
    }
    // mutator and accessor methods for other data fields
    public int getWant(){
        return this.want;
    }
    public int getHave(){
        return this.have;
    }
    public void setHave(int num){
        this.have = num;
    }
    public void setWant(int num){
        this.want=num;
    }
    public void removeAllWait(){
        waitingList.removeAll();
    }
    public int getWaitLen(){
        return waitingList.size();
    }
    public void printWait(){
        waitingList.printAll();
    }
    public String getTitle(){
        return this.title;
    }

    // define how StockItems are compared, only by title
    public int compareTo(Object rhs) {
        return title.compareTo(((StockItem)rhs).title);
    }

    // for displaying StockItem instances
    public String toString() {
        return  "Title: " + this.title + "\n" +
                "    Have value: " + this.have + "\n" +
                "    Want Value: " + this.want + "\n";
    }
}

