package ProgAssignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by JonathanDay4 on 3/17/2017.
 */
public class BookSpecTask extends Task {

    public BookSpecTask(User sessionOwner, Date today) {
        super(sessionOwner, today);
    }


    public Boolean executeTask(HashMap<String, User> Users, ArrayList<Book> bookCatalog) {
        Scanner input = new Scanner(System.in);


        System.out.println("Enter the main classification:");
        String mainClassification = input.nextLine();
        System.out.println("Enter the sub classification:");
        String subClassification = input.nextLine();
        System.out.println("Enter the serial number:");
        String serialNumber = input.nextLine();

        results(bookCatalog, mainClassification,subClassification,serialNumber);
        return true;


    }



    public void results(ArrayList<Book> catalog, String mainClassification, String subClassification, String serialNumber){
        boolean hasBeenFound = false;

        for(Book book : catalog){
            if(book.getClassification(BookClassification.mainClassification).toString().equals(mainClassification)
                    && book.getClassification(BookClassification.SubClassification).toString().equals(subClassification)
                    && book.getClassification(BookClassification.Serial_Number).toString().equals(serialNumber)) {
                        hasBeenFound = true;
                       book.printBookData();
                       System.out.println("copy number: " + book.getClassification(BookClassification.Copy_Number));
                       if(!book.isCheckedIn()) {
                           System.out.println("Book is due on: ");
                           book.getDueDate().print();
                       } else
                           System.out.println("Available for checkout.");
            }

        }

        if(!hasBeenFound) {
            System.out.println("Sorry, no books match your magic number");
            System.out.println(" ");

        }
    }






    public void displayBookData(Book book){
        book.printBookData();

    }





}
