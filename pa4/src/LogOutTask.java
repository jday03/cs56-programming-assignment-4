import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JonathanDay4 on 3/17/2017.
 */
public class LogOutTask extends Task {
    public LogOutTask(User sessionOwner, Date today) {
        super(sessionOwner, today);
    }

    public Boolean executeTask(HashMap<String, User> Users, ArrayList<Book> bookCatalog) {
        System.out.println("----- SESSION HAS ENDED-----");

        return null;
    }

}
