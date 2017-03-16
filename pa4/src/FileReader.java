import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by JonathanDay4 on 3/15/2017.
 */
public class FileReader {
    // data file specifics:

    final static int HEADER_LINES= 3;
    final static String HEADER_ROW = "::::::::::";
    final static String STUDENT_HEADER = "Students";
    final static String GRAD_RESEARCH_HEADER= "Graduate Researchers";
    final static String PROFESSOR_HEADER = "Professors";

    public static void readFile(String fileName, HashMap<Integer,User> userList, ArrayList< Book> bookCatalog) {
        File data = new File(fileName);
        Scanner reader;
        try {
            reader = new Scanner(data);
            readBooks(reader, bookCatalog);
            readUsers(reader,userList);

        } catch (FileNotFoundException error) {
            System.out.println("Data file not found.");
        }
    }





    private static void readBooks(Scanner reader,ArrayList< Book> bookCatalog ) {
        //getting past the first lines that is the header

        for (int count = 0; count < HEADER_LINES; count++){
            reader.nextLine();
        }

        String nextLine = reader.nextLine();

        while(!(nextLine.equals(HEADER_ROW))){
            bookCatalog.add(readBook(reader, nextLine));
            nextLine = reader.nextLine();
        }

    }



    private static Book readBook(Scanner reader, String firstLine){
        BookClassification currentField = BookClassification.mainClassification;
        Book newBook = BookFactory.createBook(currentField,firstLine);


        while(currentField!= BookClassification.lastStableItem()){
            String nextLine = reader.nextLine();
            currentField= currentField.next(currentField);
            BookFactory.createBook(currentField, nextLine, newBook);
        }

        return newBook;
    }


    private static void readUsers(Scanner reader, HashMap<Integer,User> userList){


        String nextLine = reader.nextLine();
        while(reader.hasNextLine()) {
            switch (nextLine) {
                case STUDENT_HEADER:
                    readSection(reader, userType.STUDENT);
                    break;
                case GRAD_RESEARCH_HEADER:
                    readSection(reader, userType.GRADUATE_RESEARCHER);
                    break;
                case PROFESSOR_HEADER:
                    readSection(reader, userType.PROFESSOR);
                    break;
                default:
                    nextLine = reader.nextLine();

            }
        }
    }


    private static void readSection(Scanner reader, userType type){
        String nextLine = reader.nextLine();
        while (nextLine.equals(HEADER_ROW)){
            nextLine = reader.nextLine();
        }




    }




}
