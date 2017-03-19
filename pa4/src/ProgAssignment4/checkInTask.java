package ProgAssignment4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JonathanDay4 on 3/16/2017.
 */
public class checkInTask extends Task{
    public checkInTask(User sessionOwner, Date today){
        super(sessionOwner, today);
    }

    public Boolean executeTask(HashMap<String,User> Users, ArrayList<Book> bookCatalog){
        Book checkIn = getBook(bookCatalog);

        if(!(currentUser.bookIsCheckedOutByThisUser(checkIn))){
            System.out.println("Error: You don't have that book checked in.");
            return false;
        }
        checkIn.checkIn();
        currentUser.checkInBook(checkIn);
        System.out.println("You have successfully checked in: " + checkIn.getFullCode());

        return true;

    }





    }
