package ProgAssignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by JonathanDay4 on 3/14/2017.
 */
public abstract class Task {

    protected User currentUser;
    protected Date today;

    public Task(User sessionOwner, Date currentDay){
        today = currentDay;
        currentUser = sessionOwner;
    }

    public Task (){

    }


    public abstract Object executeTask(HashMap<String,User> Users, ArrayList<Book> bookCatalog);




    protected Book getBook(ArrayList<Book> catalog){

        Scanner reader = new Scanner(System.in);
        String mainClassification;
        String subClassification;
        String serialNumber;
        String copyNumber;

        System.out.println("Please enter the main classification letters:");
        mainClassification = reader.nextLine();

        System.out.println("Please enter the sub classification letters:");
        subClassification = reader.nextLine();

        System.out.println("Please enter the serial number:");
        serialNumber = reader.nextLine();

        System.out.println("Please enter the copy number:");
        copyNumber= reader.nextLine();

        return Library.findBook(mainClassification,subClassification,serialNumber, copyNumber, catalog);

    }
}
