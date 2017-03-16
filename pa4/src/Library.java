import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Library {
    HashMap<Integer,User> userList = new HashMap<Integer,User>(10);
    ArrayList< Book> bookCatalog = new ArrayList<Book>(10);





    public Library(String fileName){
        FileReader.readFile(fileName, userList, bookCatalog);
    }




    public void runSession(){
        Session start = new Session();
        Task currentTask = start.beginSessionLogin();

        while(!(currentTask.executeTask(userList,bookCatalog).equals(null))){

            currentTask = start.getNextTask();

        }

        System.out.println("----- SESSION HAS BEEN CLOSED -----");
    }


}
