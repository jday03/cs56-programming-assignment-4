import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;
import java.util.Scanner;

/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Session{
    User currentUser;
    Date currentDate;


    public Date getDate(){
        return currentDate;
    }


    public Task beginSessionLogin(HashMap<String,User> Users, ArrayList<Book> bookCatalog){
         LogInTask logInDevice = new LogInTask(currentUser, Users, bookCatalog);
         currentUser = logInDevice.logIn();
         if(currentUser != null){
             currentDate = logInDevice.getDate();
         }
         return logInDevice;
    }



    public void setCurrentUser(User set){
        currentUser = set;
    }



    public Task getNextTask(){
        char job = displayMenu();
        return TaskFactory.getTask(job, currentUser, currentDate);
    }


    private char displayMenu(){
        System.out.println("Main Menu:");
        System.out.println(" ");
        System.out.println("Please input the character of the action you wish to perform:");
        System.out.println("C: Check out a book.");
        System.out.println("T: Return a book.");
        System.out.println("R: Recall a book.");
        System.out.println("    ");

        Scanner reader = new Scanner(System.in);
        return reader.next().charAt(0);
    }

}
