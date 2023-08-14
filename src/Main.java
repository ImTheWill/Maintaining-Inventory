import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        dvdDemoInv test = new dvdDemoInv();
        System.out.println("Testing command H: \n");
        test.H();
        System.out.println(" ");

        System.out.println("_________________________");
        System.out.println("Testing command A:");
        test.A("A");
        test.A("B");
        test.A("C");
        test.A("D");
        test.A("E");
        System.out.println(" ");

        System.out.println("_________________________");
        System.out.println("Testing command I:");
        test.I("A");
        System.out.println(" ");

        System.out.println("_________________________");
        System.out.println("Testing command L:");
        test.L();
        System.out.println(" ");

        System.out.println("_________________________");
        System.out.println("Testing command M:");
        test.M("A", 4);
        System.out.println("results of change of want:");
        test.I("A");
        System.out.println(" ");

        System.out.println("_________________________");
        System.out.println("Testing command D:");
        test.D("A",10);
        System.out.println("results of change of have:");
        test.I("A");
        System.out.println(" ");

        System.out.println("_________________________");
        System.out.println("Testing command O:");
        test.O();
        System.out.println(" ");

        System.out.println("_________________________");
        System.out.println("Testing command R:");
        test.R();
        System.out.println(" ");

        System.out.println("_________________________");
        System.out.println("Testing command qSave:");
        try{
            test.qSave();
            System.out.println("Save successful.");
        }catch (Exception e){
            System.out.println("Error saving.");
        }
        System.out.println(" ");

        System.out.println("_________________________");
        System.out.println("Testing command qLoad:");
        try{
            test.qLoad();
            System.out.println("Load successful.");
        }catch (Exception e){
            System.out.println("Error loading.");
        }
        System.out.println(" ");
    }
}