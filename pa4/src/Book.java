import java.util.HashMap;

/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Book {
    private HashMap<BookClassification, Object> classifications = new HashMap<BookClassification,Object>();

    public Book addClassification(BookClassification label, Object data){
        classifications.put(label,data);
        return this;
    }
}
