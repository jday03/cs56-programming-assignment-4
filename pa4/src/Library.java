
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Library {
    Map<Integer,User> userList = new HashMap<Integer,User>(10);
    Task currentTask;








    public User findUser(int ID){
        return userList.get(ID);
    }





    public void runSession(){
        Session start = new Session();
        start.getPIN(findUser(start.getID()));


        System.out.println("----- SESSION HAS BEEN CLOSED -----");
    }


}
