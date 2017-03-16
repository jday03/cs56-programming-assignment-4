import java.util.Observable;

/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class GraduateResearcher extends User {
    final int bookReturnTimeLimit = 30;
    final int booksAtATimeLimit = 15;

    public GraduateResearcher(){
        userInfo.put(UserData.Return_Time_Limit, bookReturnTimeLimit);
        userInfo.put(UserData.Books_At_A_Time_Limit, booksAtATimeLimit);
    }



}
