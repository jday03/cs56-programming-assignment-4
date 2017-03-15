
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Library {
    HashMap<Integer,User> userList = new HashMap<Integer,User>(10);
    ArrayList< Book> bookCatalog = new ArrayList<Book>();
    Task currentTask;








    public User findUser(int ID){
        return userList.get(ID);
    }





    public void runSession(){
        Session start = new Session();
        currentTask = start.beginSessionLogin();

        while(!(currentTask.executeTask(userList,bookCatalog).equals(null))){

            currentTask = start.getNextTask();

        }

        System.out.println("----- SESSION HAS BEEN CLOSED -----");
    }


}
