/**
 * Created by JonathanDay4 on 3/15/2017.
 */
public class BookFactory {


    public Book createBook( BookClassification label, String data){
        Book newBook = new Book();
        return newBook.addClassification(label,data);
    }

    public Book createBook( BookClassification label, String data, Book currentBook){
        return currentBook.addClassification(label,data);
    }
}
