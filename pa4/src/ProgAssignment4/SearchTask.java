package ProgAssignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by JonathanDay4 on 3/17/2017.
 */
public class SearchTask extends Task {
    String query;

    public SearchTask(User sessionOwner, Date today) {
        super(sessionOwner, today);

    }

    public Boolean executeTask(HashMap<String, User> Users, ArrayList<Book> bookCatalog) {
        System.out.println("What keyword would you like to search? ");
        Scanner scan = new Scanner(System.in);
        query = scan.nextLine().toLowerCase().trim();
        results(bookCatalog);

        return true;
    }

    public void results(ArrayList<Book> catalog){
        int size = catalog.size();
        boolean hasBeenFound = false;

        for(int index = 0; index < size; ++index){
            Book searcher = catalog.get(index);

            if(searcher.getClassification(BookClassification.lastStableItem()).toString().toLowerCase().contains(query)) {
                index += displayBookSpec(index, catalog, searcher);
                hasBeenFound = true;
            } else

            for(BookClassification classification = BookClassification.firstItem(); classification != BookClassification.lastStableItem(); ){
                if(searcher.getClassification(classification).toString().toLowerCase().contains(query)) {
                    index += displayBookSpec(index,catalog, searcher);
                    hasBeenFound = true;


                    classification = BookClassification.lastStableItem();
                }
                 else classification = classification.next(classification);
            }
        }
        if(!hasBeenFound) {
            System.out.println("Sorry, no books match your keyword");
            System.out.println(" ");

        }
    }


    public int displayBookSpec(int index, ArrayList<Book> catalog , Book foundBook){
        int count = 1;
        int size = catalog.size();
        while((index + count ) < size && catalog.get(index + count).sameSpec(foundBook)){
            count++;

        }

        foundBook.printBookData();

        System.out.println(count + ((count == 1)?" copy in system":" copies in system."));

        return count - 1;


    }


}