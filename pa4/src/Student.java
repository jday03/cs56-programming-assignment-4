/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Student extends User {
    final int bookReturnTimeLimit = 20;
    final int booksAtATimeLimit = 10;

    public Student (){

        userInfo.put(UserData.Return_Time_Limit, bookReturnTimeLimit);
        userInfo.put(UserData.Books_At_A_Time_Limit, booksAtATimeLimit);
    }






}
