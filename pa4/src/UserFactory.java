/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class UserFactory {

    public User addUser(String name, String email, String phoneNumber, int libraryID, int PIN,userType type, boolean blocked){

        switch(type){
            case STUDENT:
                return new Student(name,email,phoneNumber,libraryID,PIN,blocked);
            case GRADUATE_RESEARCHER:
                return new GraduateResearcher(name,email,phoneNumber,libraryID,PIN,blocked);
            case PROFESSOR:
                return new Professor(name,email,phoneNumber,libraryID,PIN,blocked);
        }
        return null;
    }



}