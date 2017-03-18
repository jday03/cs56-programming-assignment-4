import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by JonathanDay4 on 3/16/2017.
 */
public class checkOutTask extends Task {

    public checkOutTask(User sessionOwner, Date today) {
        super(sessionOwner,today);

    }

    @Override
    public Boolean executeTask(HashMap<String,User> Users, ArrayList<Book> bookCatalog){
        Book checkOut = getBook(bookCatalog);

        if (checkOut == null) {
            System.out.println("Book does not exist in library. Please try again or contact you administrator.");
            return false;
        }

        if (currentUser.isBlocked()) {
            System.out.println("You are currently blocked. Please turn in your overdue books first.");
            return false;
        }

        if (!(currentUser.isWithinBookLimit())) {
            System.out.println("You currently are at your limit for books you can have checked out at a time. Please check in a book before checking another one out.");
            return false;
        }

        if (!(checkOut.isCheckedIn())) {
            System.out.println("Book is currently checked out.");
            return false;
        }
        System.out.println("Due date: ");
        currentUser.checkOutBook(checkOut);
        Date dueDate = checkOut.checkOut(today, Integer.parseInt(currentUser.getProperty(UserData.Return_Time_Limit).toString()));
        if (dueDate != null) {
            dueDate.print();
            removeWatchers(checkOut, bookCatalog);
            checkOut.addWatcher(currentUser);
            System.out.println("You have successfully checked out: " + checkOut.getFullCode());
            return true;
        } else {
            return false;
        }
    }


    public void removeWatchers(Book checkOut, ArrayList<Book> catalog) {
        ArrayList<Book> list = Library.findBookType(checkOut.getClassification(BookClassification.mainClassification).toString(),
                checkOut.getClassification(BookClassification.SubClassification).toString(),
                checkOut.getClassification(BookClassification.Serial_Number).toString(),catalog);

            for (Book book : list) {
                book.removeWatcher(currentUser);
            }


    }
}
