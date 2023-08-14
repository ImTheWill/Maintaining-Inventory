import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class dvdDemoInv {

    private SortedList inventory = new SortedList();

    public void H(){
        System.out.println(this.inventory.H());
    }
    public void I(String title){
        this.inventory.I(title);
    }
    public void L(){
        this.inventory.L();
    }
    public void A(String title){
        this.inventory.A(title);
    }
    public void M(String title, int num){
        this.inventory.M(title,num);
    }
    public void D(String title, int stock){
        this.inventory.D(title, stock);
    }
    public void O(){
        this.inventory.O();
    }
    public void R(){
        this.inventory.R();
    }
    public void qSave(){
        try {
            FileOutputStream fos = new
                    FileOutputStream("inventory.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.inventory);
            fos.close();
        } // end try
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void qLoad(){
        SortedList restoredInventory ;
        try {
            FileInputStream fis = new
                    FileInputStream("inventory.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            restoredInventory = (SortedList) o;
            System.out.println(restoredInventory);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args){

    }
}
