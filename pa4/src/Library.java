
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Library {
    HashMap<Integer,User> userList = new HashMap<Integer,User>(10);
    ArrayList< Book> bookCatalog = new ArrayList<Book>();
    Task currentTask;

    final int HEADER_LINES= 3;
    final String HEADER_ROW = "::::::::::";



    public Library(String fileName){
        File data = new File(fileName);
        Scanner reader;
        try {
            reader = new Scanner(data);
        }catch (FileNotFoundException error){
            System.out.println("Data file not found.");
        }


    }



    private void readFile(){



    }

    private void readBooks(Scanner reader){
        //getting past the first lines that is the header

        for (int count = 0; count < HEADER_LINES; count++)
            reader.nextLine();
        String nextLine = reader.nextLine();

        while(!(nextLine.equals(HEADER_ROW))){
            readBook(reader, nextLine);

        }

    }

    private Book readBook(Scanner reader, String firstLine){
        BookClassification currentState = BookClassification.mainClassification;
        Book newBook = BookFactory.createBook(currentState,firstLine);


        while(currentState != BookClassification.mainClassification){
            String nextLine = reader.nextLine();
            currentState = currentState.next(currentState);


        }

        return newBook;
    }

    public User findUser(int ID){
        return userList.get(ID);
    }





    public void runSession(){
        Session start = new Session();
        currentTask = start.beginSessionLogin();

        while(!(currentTask.executeTask(userList,bookCatalog).equals(null))){

            currentTask = start.getNextTask();

        }

        System.out.println("----- SESSION HAS BEEN CLOSED -----");
    }


}
