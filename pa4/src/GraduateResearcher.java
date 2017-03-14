/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class GraduateResearcher extends User {
    final int bookReturnTimeLimit = 30;
    final int booksAtATimeLimit = 15;

    public GraduateResearcher(String name, String email, String phoneNumber, int libraryId, int PIN, boolean blocked){
        super(name, email, phoneNumber, libraryId, PIN, blocked);

        userInfo.put("bookReturnTimeLimit", bookReturnTimeLimit);
        userInfo.put("booksAtATimeLimit", booksAtATimeLimit);
    }

}
