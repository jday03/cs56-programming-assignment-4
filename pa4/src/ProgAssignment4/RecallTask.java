package ProgAssignment4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JonathanDay4 on 3/17/2017.
 */
public class RecallTask extends WaitTask {
    public RecallTask(User sessionOwner, Date today){
        super(sessionOwner,today);
    }



    @Override
    public Boolean executeTask(HashMap<String,User> Users, ArrayList<Book> bookCatalog){
        ArrayList <Book> books= getBooks(bookCatalog);
        ArrayList<Book> candidates = new ArrayList<Book>(books);
        books = checkedInCopies(books);

        if(books.size() == 0){
            for(Book book: candidates){
                book.recall(today);
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

}
