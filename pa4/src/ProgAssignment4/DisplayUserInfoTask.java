package ProgAssignment4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JonathanDay4 on 3/17/2017.
 */
public class DisplayUserInfoTask extends Task {
    public DisplayUserInfoTask(User sessionOwner, Date today) {
        super(sessionOwner, today);
    }

    public Boolean executeTask(HashMap<String, User> Users, ArrayList<Book> bookCatalog) {
        UserData endPoint = UserData.lastStableItem();
        ArrayList<Book> checkedOutBooks = currentUser.booksCheckedOut;
        for(UserData classification = UserData.firstItem(); classification != endPoint; classification = classification.next(classification)){
            System.out.println(classification.toString() + ": " + currentUser.getProperty(classification).toString());

        }
        System.out.println(endPoint.toString() + ": " + currentUser.getProperty(endPoint).toString());
        if(currentUser.isBlocked())
            System.out.println("You are currently blocked due to overdue books.");

    if(checkedOutBooks.size() == 0)
        System.out.println("You currently don't have any books checked out.");
    else{
        System.out.println("You have checked out these books:");
        for(Book book: checkedOutBooks){

            book.printBookData();
            System.out.println("copy number: " + book.getClassification(BookClassification.Copy_Number));
            System.out.println("Book is due on: ");
            book.getDueDate().print();
        }


    }
    System.out.println(" ");

    return true;
    }


}