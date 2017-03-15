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

        int ID = getID();
        int PIN = getPIN();


        return new LogInTask(PIN, ID);

    }

    public int getID(){
        System.out.println("Enter Student ID:");
        int ID = 0; // MUST GET INPUT.
        return ID;
    }


    public int getPIN(){
        System.out.println("Enter user PIN:");
        //GET PIN
        int PIN = 0;

        return PIN;
    }

    public void setCurrentUser(User )


}
