import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by JonathanDay4 on 3/16/2017.
 */
public class checkOutTask extends Task{

    public checkOutTask(User sessionOwner, Date today){
        super(sessionOwner);
    }

    @Override
    public Boolean executeTask(HashMap<Object,User> Users, ArrayList<Book> bookCatalog){
        Book checkOut = getBook(bookCatalog);
        if(checkOut == null){
            System.out.println("Book does not exist in library. Please try again or contact you administrator.");
            return false;
        }
        if(currentUser.isBlocked()){
            System.out.println("You are currently blocked. Please turn in your overdue books first.");
            return false;
        }
        if(!(currentUser.isWithinBookLimit())){
            System.out.println("You currently are at your limit for books you can have checked out at a time. Please check in a book before checking another one out.");
            return false;
        }
        if(!(checkOut.isCheckedIn())) {
            System.out.println("Book is currently checked out.");
            return false;
        }

            currentUser.checkOutBook(checkOut);
            Date dueDate = checkOut.checkOut(today, Integer.parseInt(currentUser. getProperty(UserData.Return_Time_Limit).toString()));
            if(dueDate != null) {
                dueDate.print();
                return true;
            } else {
                return false;
            }
    }

    private Book getBook(ArrayList<Book> catalog){

        Scanner reader = new Scanner(System.in);
        String mainClassification;
        String subClassification;
        String serialNumber;
        String copyNumber;

        System.out.println("please enter the main classification letters:");
        mainClassification = reader.nextLine();

        System.out.println("please enter the sub classification letters:");
        subClassification = reader.nextLine();

        System.out.println("please enter the serial number:");
        serialNumber = reader.nextLine();

        System.out.println("please enter the copy number:");
        copyNumber= reader.nextLine();

        return Library.findBook(mainClassification,subClassification,serialNumber, copyNumber, catalog);

    }
}
