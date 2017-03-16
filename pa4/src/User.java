import java.util.HashMap;
import java.util.Map;

/**
 * Created by JonathanDay4 on 3/13/2017.
 */
abstract public class User {

    protected Map <UserData,Object> userInfo = new HashMap<UserData, Object>();


    public User(){

    }


    public User addClassification(UserData label, Object data){
        userInfo.put(label,data);
        return this;
    }


    public Object getProperty(UserData data){
        return userInfo.get(data);
    }

}
