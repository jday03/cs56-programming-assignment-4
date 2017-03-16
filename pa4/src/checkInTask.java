import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by JonathanDay4 on 3/16/2017.
 */
public class checkInTask extends Task{
    public checkInTask(User sessionOwner, Date today){
        super(sessionOwner);
    }

    public Boolean executeTask(HashMap<Object,User> Users, ArrayList<Book> bookCatalog){
        Book checkIn = getBook(bookCatalog);

        if(!(currentUser.bookIsCheckedOutByThisUser(checkIn))){
            return false;
        }
        checkIn.checkIn();
        currentUser.checkInBook(checkIn);
        return true;

    }





    }
