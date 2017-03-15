import java.util.HashMap;
import java.util.Map;

/**
 * Created by JonathanDay4 on 3/13/2017.
 */
abstract public class User {

    protected Map <String,Object> userInfo = new HashMap<String, Object>();


    public User(String name, String email, String phoneNumber, int libraryId, int PIN, boolean blocked){

        userInfo.put("name", name);
        userInfo.put("email", email);
        userInfo.put("phonenumber", phoneNumber);
        userInfo.put("ID", libraryId);
        userInfo.put("PIN", PIN);
        userInfo.put("blocked", blocked);


    }

    public Object getProperty(String property){
        Object propertyToReturn = userInfo.getOrDefault(property, -300);
        assert(!(propertyToReturn.equals(-300)));
        return propertyToReturn;
    }

}
