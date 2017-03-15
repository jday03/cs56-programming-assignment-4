import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JonathanDay4 on 3/14/2017.
 */
public interface Task {
    public Object executeTask(HashMap<Integer,User> Users, ArrayList<Book> bookCatalog);
}
