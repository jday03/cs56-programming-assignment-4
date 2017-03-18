import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by JonathanDay4 on 3/16/2017.
 */
public class WaitTask extends Task{
    public WaitTask(User sessionOwner, Date today){
        super(sessionOwner,today);
    }

    @Override
    public Boolean executeTask(HashMap<String,User> Users, ArrayList<Book> bookCatalog){
        ArrayList <Book> books= getBooks(bookCatalog);
        ArrayList<Book> candidates = new ArrayList<Book>(books);
        books = checkedInCopies(books);

        if(books.size() == 0){
            for(Book book: candidates){
                book.addWatcher(currentUser);
                System.out.println("You are now following: " + book.getFullCode());
            }
        } else{
            System.out.println("Available copies: ");
            for(Book book: books){
                System.out.println(book.getFullCode());

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
        ArrayList <Book> newCandidates = new ArrayList<Book>(candidates);
        for (Book book : candidates){
            if(!(book.isCheckedIn()))
                newCandidates.remove(book);
        }
        return newCandidates;
    }
}
