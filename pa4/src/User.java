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



    public boolean checkOutBook(Book checkOut){
        if((booksCheckedOut.size() > booksAtATimeLimit) || (userInfo.get(UserData.Blocked) != null))
            return false;
        booksCheckedOut.add(checkOut);
        return true;
    }

    public boolean bookIsCheckedOutByThisUser(Book test){
        return booksCheckedOut.lastIndexOf(test) != -1;
    }

    public boolean checkInBook(Book checkIn){
        if(booksCheckedOut.remove(checkIn))
        return true;
        else {

            System.out.println("Book is not checked out by user.");
            return false;
        }
    }

    public boolean isWithinBookLimit(){

        return !(booksCheckedOut.size() > booksAtATimeLimit);
    }

    public boolean isBlocked(){
        return (userInfo.get(UserData.Blocked) != null);
    }


    public void update(Observable o, Object arg){
        System.out.println("[Message to ID " + getProperty(UserData.ID) + "]Book with magic number" + " and copy number " + arg.toString() + " has become available! Pick it up ASAP!");

    }


}
