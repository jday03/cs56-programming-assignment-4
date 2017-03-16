import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JonathanDay4 on 3/14/2017.
 */
public class LogInTask implements Task{

    public LogInTask(){

    }

    @Override
    public User executeTask(HashMap<Object,User> Users, ArrayList<Book> bookCatalog){
        Object ID = getID();
        Object PIN = getPIN();

        User logInUser = Users.get(ID);
        if(logInUser == null) {
            System.out.println("There is no user with that ID.");
            return null;
        }
        if(logInUser.getProperty(UserData.ID).equals(PIN)){

            return logInUser;
        } else {
            System.out.println("PIN incorrect.");
            return null;
        }
    }


    private int getID(){
        System.out.println("Enter Student ID:");
        int ID = 0; // MUST GET INPUT.
        return ID;
    }


    private int getPIN(){
        System.out.println("Enter user PIN:");
        //GET PIN
        int PIN = 0;

        return PIN;
    }
}
