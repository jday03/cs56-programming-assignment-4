package ProgAssignment4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JonathanDay4 on 3/17/2017.
 */
public class ReShowMenuTask extends Task {
    public ReShowMenuTask(User sessionOwner, Date today) {
        super(sessionOwner, today);
    }

    public Boolean executeTask(HashMap<String, User> Users, ArrayList<Book> bookCatalog) {
        return true;
    }
}
