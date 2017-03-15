/**
 * Created by JonathanDay4 on 3/13/2017.
         */
public class Professor extends User{
    final int bookReturnTimeLimit = 30;
    final int booksAtATimeLimit = 20;

    public Professor(String name, String email, String phoneNumber, int libraryId, int PIN, boolean blocked){
        super(name, email, phoneNumber, libraryId, PIN, blocked);

        userInfo.put("bookReturnTimeLimit", bookReturnTimeLimit);
        userInfo.put("booksAtATimeLimit", booksAtATimeLimit);
    }
}
