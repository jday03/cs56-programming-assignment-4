package ProgAssignment4;

/**
 * Created by JonathanDay4 on 3/13/2017.
         */
public class Professor extends User{
    final static int bookReturnTimeLimit = 30;
    final static int booksAtATimeLimit = 20;

    public Professor(){
        super(bookReturnTimeLimit, booksAtATimeLimit);
        userInfo.put(UserData.Return_Time_Limit, bookReturnTimeLimit);
        userInfo.put(UserData.Books_At_A_Time_Limit, booksAtATimeLimit);
    }
}
