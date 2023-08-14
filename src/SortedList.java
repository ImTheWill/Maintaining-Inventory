import java.io.*;
import java.util.*;

public class SortedList implements Serializable {
    private ListStock listOfStockItems = new ListStock();
    public String H(){
        return
                "I <title> (inquire): Displays the inventory information for a specified title. \n" +
                "L (list): Lists the entire inventory in alphabetical order by title.\n" +
                "A <title> (add): Adds a new title to the inventory and prompts for the initial want value.\n" +
                "M <title> (modify): Modifies the want value for a specified title.\n" +
                "D (delivery): Takes delivery of a shipment of DVDs, reserves DVDs for wait-listed\n" +
                "     customers, and updates the inventory accordingly. Adds the title to the inventory if it's not\n" +
                "     already present.\n" +
                "O (order): Writes a purchase order for additional DVDs based on a comparison of the have\n" +
                "     and want values in the inventory to bring the have value up to the want value.\n" +
                "R (return): Writes a return order based on a comparison of the have and want values in the\n" +
                "     inventory, decreasing the have values accordingly to reduce them to the want value.\n" +
                "S <title> (sell): Decreases the count for the specified title by 1. If the title is sold out, adds a\n" +
                "     name to the wait list for the title.\n" +
                "Q (quit): Saves the inventory and wait lists in a file and terminates the program's execution.";
    }
    public void I(String title){
        NodeStock stockItem = listOfStockItems.find(title);
        if(stockItem == null){
            System.out.println("DVD Title not found");
            A(title);

        }
        else{
            System.out.println(stockItem.item.toString());
        }

    }
    public void L(){
        ListStock sortedStockList = new ListStock();

        int j = 0;
        for(char i  = 'A'; i <= 'Z';i++){
            while(j<listOfStockItems.size()){
                char k = listOfStockItems.get(j).getTitle().charAt(0);
                if(k == i){
                    sortedStockList.add(listOfStockItems.get(j));
                }
                j++;
            }
            j= 0;
        }
        sortedStockList.printAll();

    }
    //add ability to add customer to stockItem wait list as it wont increment if want value is only increased
    public void A(String title){
        Scanner in = new Scanner(System.in);
        System.out.println("Input want value");
        int want = in.nextInt();
        try {
            //adds to non-empty list
            int listLen = listOfStockItems.size();
            listOfStockItems.add(listLen, new StockItem(title, want, 0));
        }catch (Exception e){
            //adds to empty list
            listOfStockItems.add(0, new StockItem(title, want, 0));
        }

    }
    public void M(String title, int num){
        NodeStock stockItem = listOfStockItems.find(title);
        stockItem.item.setWant(num);

    }

    //make sure to reserve and remove waitlist when delivery comes in;
    public void D(String title, int deliveryStock){
        NodeStock stockItem = listOfStockItems.find(title);
        if(stockItem == null){
            listOfStockItems.add(new StockItem(title,0,deliveryStock));
        }
        else{
            int waitListLen = stockItem.item.getWaitLen();
            deliveryStock = deliveryStock - waitListLen;
            if(deliveryStock>0){
                stockItem.item.setHave(deliveryStock);
            } else if (deliveryStock == 0) {
                stockItem.item.setHave(0);
                stockItem.item.setWant(0);
                stockItem.item.removeAllWait();
            }
            else{
                stockItem.item.setHave(0);
                stockItem.item.setWant(-1*deliveryStock);
            }

        }


    }
    public void O(){
        //writing purchase order
        int i = 0;
        int purchaseCount = 0 ;
        while(i < listOfStockItems.size()){
            StockItem stockItem = listOfStockItems.get(i);
            int want = stockItem.getWant();
            int have = stockItem.getHave();
            if(want-have > 0){
                stockItem.setHave(have + (want-have));
                purchaseCount = (want-have) + purchaseCount;
                System.out.println("purchasing " + stockItem.getTitle() + " "+ (want-have) + " DVDs.");
            }
            i++;
        }
        System.out.println("purchased " + purchaseCount +" DVDs.");

    }
    public void R(){
        int i = 0;
        int returnCount = 0 ;
        while(i < listOfStockItems.size()){
            StockItem stockItem = listOfStockItems.get(i);
            int want = stockItem.getWant();
            int have = stockItem.getHave();
            if(have-want > 0){
                stockItem.setHave(have - (have-want));
                returnCount = (have-want) + returnCount;
                System.out.println("returning " + stockItem.getTitle() + " "+ (have-want) + " DVDs.");
            }
            i++;
        }
        System.out.println("Returned " + returnCount +" DVDs.");

    }
    public void S(String title){
        StockItem stockItem = listOfStockItems.find(title).item;
        if(stockItem.getHave() == 0){
            Scanner in = new Scanner(System.in);
            String first = in.nextLine();
            String last = in.nextLine();
            String num = in.nextLine();
            stockItem.addToWaitingList(first,last,num);
            System.out.println("Added customer: " + first + " " + last + " to wait list.");
        }
        else{
            stockItem.setHave(stockItem.getHave()-1);
            System.out.println("Sold " + stockItem.getTitle()+ "DVD.");
        }


    }



}
