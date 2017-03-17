import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by JonathanDay4 on 3/16/2017.
 */
public class RecallTask extends Task{
    public RecallTask(User sessionOwner, Date today){
        super(sessionOwner);
    }

    @Override
    public Boolean executeTask(HashMap<Object,User> Users, ArrayList<Book> bookCatalog){
        ArrayList <Book> books= getBooks(bookCatalog);
        ArrayList<Book> candidates = (ArrayList<Book> ) books.clone();
        books = checkedInCopies(books);

        if(books.size() == 0){
            for(Book book: candidates){
                book.recall(today);
                book.addWatcher(currentUser);

            }


        }
return true;



    }

    protected ArrayList<Book> getBooks(ArrayList<Book> catalog){

        Scanner reader = new Scanner(System.in);
        String mainClassification;
        String subClassification;
        String serialNumber;

        System.out.println("Please enter the main classification letters:");
        mainClassification = reader.nextLine();

        System.out.println("Please enter the sub classification letters:");
        subClassification = reader.nextLine();

        System.out.println("Please enter the serial number:");
        serialNumber = reader.nextLine();

        return Library.findBookType(mainClassification,subClassification,serialNumber, catalog);

    }



    public ArrayList <Book> checkedInCopies(ArrayList <Book> candidates){
        for (Book book : candidates){
            if(!(book.isCheckedIn()))
                candidates.remove(book);
        }
        return candidates;
    }
}
