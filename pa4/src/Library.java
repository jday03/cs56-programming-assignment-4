import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Library {
    HashMap<Object,User> userList = new HashMap<Object,User>(10);
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


    public static Book findBook(String mainClassification, String subClassification, String serialNumber, String copyNumber, ArrayList<Book> catalog){
        for (Book book : catalog){
            if(book.getClassification(BookClassification.mainClassification).equals(mainClassification)
                    && book.getClassification(BookClassification.SubClassification).equals(subClassification)
                    && book.getClassification(BookClassification.Serial_Number).equals(serialNumber)
                    && book.getClassification(BookClassification.Copy_Number).equals(copyNumber))
                return book;
        }

        return null;
    }


    public static ArrayList<Book> findBookType(String mainClassification, String subClassification, String serialNumber, ArrayList<Book> catalog){
        ArrayList<Book> list = new ArrayList<Book>();
        for (Book book : catalog){
            if(book.getClassification(BookClassification.mainClassification).equals(mainClassification)
                    && book.getClassification(BookClassification.SubClassification).equals(subClassification)
                    && book.getClassification(BookClassification.Serial_Number).equals(serialNumber))
                list.add(book);
        }
        if (list.size() != 0)
            return list;
        return null;
    }



}


