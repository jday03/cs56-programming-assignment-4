import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JonathanDay4 on 3/14/2017.
 */
public abstract class Task {

    protected User currentUser;
    protected Date today;

    public Task(User sessionOwner){
        currentUser = sessionOwner;
    }

    public abstract Object executeTask(HashMap<Object,User> Users, ArrayList<Book> bookCatalog);
}
