/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Student extends User {
    final int bookReturnTimeLimit = 20;
    final int booksAtATimeLimit = 10;

    public Student (String name, String email, String phoneNumber, int libraryId, int PIN, boolean blocked){
        super(name, email, phoneNumber, libraryId, PIN, blocked);

        userInfo.put("bookReturnTimeLimit", bookReturnTimeLimit);
        userInfo.put("booksAtATimeLimit", booksAtATimeLimit);
    }






}
