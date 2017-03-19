package ProgAssignment4;

/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class GraduateResearcher extends User {
    final static int bookReturnTimeLimit = 30;
    final static int booksAtATimeLimit = 15;

    public GraduateResearcher(){
        super(bookReturnTimeLimit, booksAtATimeLimit);

        userInfo.put(UserData.Return_Time_Limit, bookReturnTimeLimit);
        userInfo.put(UserData.Books_At_A_Time_Limit, booksAtATimeLimit);
    }



}
