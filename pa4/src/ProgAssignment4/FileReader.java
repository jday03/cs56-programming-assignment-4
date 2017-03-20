package ProgAssignment4;

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
    final static String BLOCKED_TAG = "[Blocked]";
    final static String BOOKS_CHECKED_TAG = "/";

    public static void readFile(String fileName, HashMap<String,User> userList, ArrayList<  Book> bookCatalog) {
        File data = new File(fileName);
        Scanner reader;
        try {
            reader = new Scanner(data);
            readBooks(reader, bookCatalog);
            readUsers(reader,userList, bookCatalog);

        } catch (FileNotFoundException error) {
            System.out.println("Data file not found.");
        }
    }





    private static void readBooks(Scanner reader, ArrayList< Book> bookCatalog ) {
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
        BookClassification currentField = BookClassification.firstItem();

        Book newBook = BookFactory.createBook(firstLine);
        currentField = currentField.next(currentField);
        currentField = currentField.next(currentField);

        while(currentField!= BookClassification.lastStableItem()){
            String nextLine = reader.nextLine();
            currentField= currentField.next(currentField);
            BookFactory.createBook(currentField, nextLine, newBook);
        }

        return newBook;
    }


    private static void readUsers(Scanner reader, HashMap<String,User> userList, ArrayList <Book> bookCatalog){



        while(reader.hasNextLine()) {
            String nextLine = reader.nextLine();
            switch (nextLine) {
                case STUDENT_HEADER:
                    readSection(reader, UserType.STUDENT, userList, bookCatalog);
                    break;
                case GRAD_RESEARCH_HEADER:
                    readSection(reader, UserType.GRADUATE_RESEARCHER, userList, bookCatalog);
                    break;
                case PROFESSOR_HEADER:
                    readSection(reader, UserType.PROFESSOR, userList, bookCatalog);
                    break;


            }
        }
    }


    private static void readSection(Scanner reader, UserType type, HashMap<String,User> userList, ArrayList <Book> bookCatalog){
        String nextLine = reader.nextLine();
        while (nextLine.equals(HEADER_ROW)){
            nextLine = reader.nextLine();
        }

        while(!(nextLine.equals(HEADER_ROW)) && reader.hasNextLine()){
            User toAdd = readUser(reader,type,nextLine);
            userList.put(toAdd.getProperty(UserData.ID).toString(),toAdd);

            nextLine = reader.nextLine();

            if(nextLine.contains(BOOKS_CHECKED_TAG)){
                addCheckedOutBooks(toAdd, nextLine, bookCatalog );
                if(reader.hasNextLine())
                    nextLine = reader.nextLine();

            }
            if(nextLine.contains(BLOCKED_TAG)) {
                toAdd.addClassification(UserData.Blocked, true);
                if(reader.hasNextLine())
                    nextLine = reader.nextLine();

            }



        }



    }


    private static User readUser(Scanner reader, UserType type, String nextLine){
        UserData currentField = UserData.firstItem();
        User newUser = UserFactory.createUser(type);
        newUser = UserFactory.createUser(currentField,nextLine,newUser);

        while(currentField!= UserData.lastStableItem()){
            nextLine = reader.nextLine();
            currentField= currentField.next(currentField);
            newUser = UserFactory.createUser(currentField,nextLine,newUser);
        }
        return newUser;
    }



    private static User addCheckedOutBooks(User previousUser, String line, ArrayList <Book> bookCatalog){
        int firstIndexOfSlash;
        int secondIndexOfSlash;
        int indexOfColon;

        int startOfSubClassification;
        int startOfSerialNumber;
        int copyQuantityLocation;
        int separationBetweenMagicNumbers = -1;

        int checkoutYear;
        int checkoutMonth;
        int checkoutDay;

        do {
            line = line.substring(separationBetweenMagicNumbers + 1);

            firstIndexOfSlash = line.indexOf("/");
            secondIndexOfSlash = line.indexOf("/", firstIndexOfSlash + 1);
            indexOfColon = line.indexOf(":");

            checkoutYear = Integer.parseInt(line.substring(0, firstIndexOfSlash));
            checkoutMonth = Integer.parseInt(line.substring(firstIndexOfSlash + 1, secondIndexOfSlash));
            checkoutDay = Integer.parseInt(line.substring(secondIndexOfSlash + 1, indexOfColon));
            int [] date = {checkoutYear, checkoutMonth, checkoutDay};

            line = line.substring(indexOfColon + 1);

            startOfSubClassification = line.indexOf(".");
            startOfSerialNumber = line.indexOf(".", startOfSubClassification + 1);
            copyQuantityLocation = line.indexOf(":");

            separationBetweenMagicNumbers = line.indexOf(",");
            separationBetweenMagicNumbers = (separationBetweenMagicNumbers >= 0) ? separationBetweenMagicNumbers : line.length();

            String mainClassification = line.substring(0, startOfSubClassification);
            String subClassification = line.substring(startOfSubClassification + 1, startOfSerialNumber);
            String serialNumber = line.substring(startOfSerialNumber + 1, copyQuantityLocation);
            String copyNumber = line.substring(copyQuantityLocation + 1, separationBetweenMagicNumbers);

            Book foundBook = Library.findBook(mainClassification, subClassification, serialNumber,copyNumber, bookCatalog);
            Date checkOutDate = new Date( checkoutYear, checkoutMonth, checkoutDay);
            foundBook.changeCheckOutDate( checkOutDate);
            Date dueDate = new Date (checkOutDate);
            dueDate.changeDate(previousUser.bookReturnTimeLimit);
            foundBook.setDueDate(dueDate);
            foundBook.addWatcher(previousUser);
            previousUser.checkOutBook(foundBook);

            int test = line.length();

        } while (separationBetweenMagicNumbers != line.length());

        return null;
    }







}
