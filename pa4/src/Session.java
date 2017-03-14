import java.util.Observer;

/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Session{
    User currentUser;

    public Session(){
        currentUser = login();

        if(currentUser != null) {

        }
    }


    public User login(){

        System.out.println("Enter Student PIN:");
        int PIN;




    }

    public int getID(){
        System.out.println("Enter Student ID:");
        int ID = 0; // MUST GET INPUT.
        return ID;
    }


    public int getPin(User currentUser){
        if(currentUser == null) {
            System.out.println("User does not exist.");
            return -999;
        }
        this.currentUser = currentUser;
        System.out.println("Enter user PIN:");
        //GET PIN
        int PIN;





    }



}
