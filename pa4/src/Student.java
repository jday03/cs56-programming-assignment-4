/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Student extends User {
    final static int bookReturnTimeLimit = 20;
    final static int booksAtATimeLimit = 10;

    public Student (){
        super(bookReturnTimeLimit, booksAtATimeLimit);

        userInfo.put(UserData.Return_Time_Limit, bookReturnTimeLimit);
        userInfo.put(UserData.Books_At_A_Time_Limit, booksAtATimeLimit);
    }






}
