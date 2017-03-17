import static java.lang.Character.toLowerCase;

/**
 * Created by JonathanDay4 on 3/16/2017.
 */
public class TaskFactory {

    public static Task getTask(char job, User sessionOwner, Date today){
        job = toLowerCase(job);
        switch(job){
            case 'c':
                return new checkOutTask(sessionOwner,today);
            case 't':
                return new checkInTask(sessionOwner,today);
            case 'r':
                return new RecallTask(sessionOwner,today);
            case 's':
                return new SearchTask(sessionOwner,today);
            case 'd':
                return new BookSpecTask(sessionOwner,today);
            case 'u':
                return new DisplayUserInfoTask(sessionOwner,today);

            default:
                return new closeTask();
        }

    }
}
