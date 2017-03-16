/**
 * Created by JonathanDay4 on 3/15/2017.
 */
 public class BookFactory {
    final static String BUFFER_CHARACTER = ".";


    static public Book createBook( BookClassification label, String firstLine){

        Book newBook = new Book();
        addMagicNumber(label,firstLine,newBook);

        return newBook;
    }



    private static Book addMagicNumber(BookClassification label, String firstLine, Book newBook){
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
