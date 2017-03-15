import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JonathanDay4 on 3/14/2017.
 */
public class LogInTask implements Task{
    int ID;
    int PIN;

    public LogInTask(int ID, int PIN){
        this.ID = ID;
        this.PIN = PIN;
    }

    @Override
    public User executeTask(HashMap<Integer,User> Users, ArrayList<Book> bookCatalog){

        User logInUser = Users.get(ID);
        if(logInUser == null) {
            System.out.println("There is no user with that ID.");
            return null;
        }
        if(logInUser.getProperty("PIN").equals(PIN)){

            return logInUser;
        } else {
            System.out.println("PIN incorrect.");
            return null;
        }
    }

}
