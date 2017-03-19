package ProgAssignment4;

/**
 * Created by JonathanDay4 on 3/15/2017.
 */
 public class BookFactory {
    final static String BUFFER_CHARACTER = ".";


    static public Book createBook( String firstLine){

        Book newBook = new Book();
        addMagicNumber(firstLine,newBook);

        return newBook;
    }



    private static Book addMagicNumber(String firstLine, Book newBook){
        BookClassification label = BookClassification.mainClassification;
        int firstIndexOfDot = firstLine.indexOf(BUFFER_CHARACTER);
        int secondIndexOfDot = firstLine.indexOf(BUFFER_CHARACTER,firstIndexOfDot + 1);

        String firstPart = firstLine.substring(0, firstIndexOfDot);
        String secondPart = firstLine.substring(firstIndexOfDot + 1, secondIndexOfDot);
        String thirdPart = firstLine.substring(secondIndexOfDot + 1, firstLine.length());

        newBook.addClassification(label,firstPart);
        label = label.next(label);
        newBook.addClassification(label,secondPart);
        label = label.next(label);
        return newBook.addClassification(label,thirdPart);


    }
    static public Book createBook( BookClassification label, String data, Book currentBook){
        return currentBook.addClassification(label,data);
    }
}
