import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Date;
import java.util.Observer;

/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Session{
    User currentUser;
    Date currentDate;




    public Task beginSessionLogin(){
        return new LogInTask();

    }



    public void setCurrentUser(User set){
        currentUser = set;
    }



    public Task getNextTask(){
        displayMenu();
        return null;
    }


    private void displayMenu(){
        System.out.println("Main Menu:");
        System.out.println(" ");
        System.out.println("Please input the character of the action you wish to perform:");


    }

}
