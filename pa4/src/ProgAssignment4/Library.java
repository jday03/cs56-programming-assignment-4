package ProgAssignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Library {
   private HashMap<String,User> userList = new HashMap<String,User>(10);
   private ArrayList< Book> bookCatalog = new ArrayList<Book>(10);





    public Library(String fileName){
        FileReader.readFile(fileName, userList, bookCatalog);
    }







    public void runSession(){

        String nextLine;
        do {

            Session start = new Session();
            Task currentTask = start.beginSessionLogin(userList, bookCatalog);
            updateBlocks(start.getDate());

            while (!(currentTask.executeTask(userList, bookCatalog) == null)) {

            currentTask = start.getNextTask();

            }

            System.out.println("Would you like to exit the program now? (y/n)" );
            Scanner scan = new Scanner(System.in);
            nextLine = scan.nextLine();
        }while(nextLine.equals("n"));

        System.out.println("----- Library HAS BEEN CLOSED -----");
    }





    private void updateBlocks(Date today) {
        if (today != null) {

            Set userSet = userList.keySet();
            for (Object tracker : userSet) {
                User currentUser = userList.get(tracker.toString());
                ArrayList<Book> bookList = currentUser.getBookList();
                for (Book checkedOut : bookList) {
                    if (today.isGreaterThan(checkedOut.getDueDate())) {
                        if (currentUser.getProperty(UserData.Blocked) == null)
                            currentUser.addClassification(UserData.Blocked, true);
                    }

                }

            }
        }
    }






    public static Book findBook(String mainClassification, String subClassification, String serialNumber, String copyNumber, ArrayList<Book> catalog){
        for (Book book : catalog){
            if(book.getClassification(BookClassification.mainClassification).equals(mainClassification)
                    && book.getClassification(BookClassification.SubClassification).equals(subClassification)
                    && book.getClassification(BookClassification.Serial_Number).equals(serialNumber)
                    && book.getClassification(BookClassification.Copy_Number).equals(copyNumber))
                return book;
        }

        return null;
    }


    public static ArrayList<Book> findBookType(String mainClassification, String subClassification, String serialNumber, ArrayList<Book> catalog){
        ArrayList<Book> list = new ArrayList<Book>();
        for (Book book : catalog){
            if(book.getClassification(BookClassification.mainClassification).equals(mainClassification)
                    && book.getClassification(BookClassification.SubClassification).equals(subClassification)
                    && book.getClassification(BookClassification.Serial_Number).equals(serialNumber))
                list.add(book);
        }
        if (list.size() != 0)
            return list;
        return null;
    }



}


