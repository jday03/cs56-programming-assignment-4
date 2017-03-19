package ProgAssignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by JonathanDay4 on 3/14/2017.
 */
public class LogInTask extends Task{
    HashMap<String,User> usersList;
    ArrayList<Book> bookList;

    public LogInTask(User sessionOwner, HashMap<String,User> Users, ArrayList<Book> bookCatalog){
        super(sessionOwner, new Date(0,0,0));
        usersList = Users;
        bookList = bookCatalog;


    }

    @Override
    public User executeTask(HashMap<String,User> Users, ArrayList<Book> bookCatalog){
        return currentUser;
    }



    public Date getDate(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter today's year:");
        int year = input.nextInt();
        System.out.println("Enter today's month:");
        int month = input.nextInt();
        System.out.println("Enter today's date:");
        int date = input.nextInt();

        return new Date(year,month,date);
    }




    public User logIn(){
        String ID = getID();
        String PIN = getPIN();

        User logInUser = usersList.get(ID);


        if(logInUser != null && logInUser.getProperty(UserData.PIN).toString().equals(PIN)){
            currentUser = logInUser;
            return logInUser;
        } else {
            System.out.println("PIN or ID is incorrect.");
            return null;
        }

    }




    private String getID(){
        System.out.println("Enter Student ID:");
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }


    private String getPIN(){
        System.out.println("Enter user PIN:");
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }
}
