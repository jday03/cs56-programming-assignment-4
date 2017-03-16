/**
 * Created by JonathanDay4 on 3/15/2017.
 */
 public class BookFactory {


    static public Book createBook( BookClassification label, String firstLine){
        final String BUFFER_CHARACTER = ".";

        Book newBook = new Book();
        int firstIndexOfDot = firstLine.indexOf(BUFFER_CHARACTER);
        int secondIndexOf = firstLine.indexOf(BUFFER_CHARACTER,firstIndexOfDot);

        String firstPart = firstLine.substring(0, firstIndexOfDot);
        String secondPart = firstLine.substring(firstIndexOfDot, secondIndexOf);
        String thirdPart = firstLine.substring(firstIndexOfDot, firstLine.length());

        newBook.addClassification(label,firstPart);
        label = label.next(label);
        newBook.addClassification(label,secondPart);
        label = label.next(label);
        return newBook.addClassification(label,firstPart);


    }

    static public Book createBook( BookClassification label, String data, Book currentBook){
        return currentBook.addClassification(label,data);
    }
}
