import java.util.*;

/**
 * Created by JonathanDay4 on 3/13/2017.
 */
abstract public class User implements Observer {

    protected Map <UserData,Object> userInfo = new HashMap<UserData, Object>();
    protected ArrayList< Book> booksCheckedOut = new ArrayList<Book>(10);

    final int bookReturnTimeLimit = 5;
    final int booksAtATimeLimit = 5;

    public User(){

    }


    public User addClassification(UserData label, Object data){
        userInfo.put(label,data);
        return this;
    }


    public Object getProperty(UserData data){
        return userInfo.get(data);
    }



    public boolean checkOutBook(Book checkout){
        if((booksCheckedOut.size() > booksAtATimeLimit) || (userInfo.get(UserData.Blocked) != null))
            return false;
        booksCheckedOut.add(checkout);
        return true;
    }

    public boolean isWithinBookLimit(){

        return !(booksCheckedOut.size() > booksAtATimeLimit);
    }

    public boolean isBlocked(){
        return (userInfo.get(UserData.Blocked) != null);
    }


    public void update(Observable o, Object arg){


    }


}
