package ProgAssignment4;

import java.util.HashMap;
import java.util.Observable;

/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class Book extends Observable{

    private HashMap<BookClassification, Object> classifications = new HashMap<BookClassification,Object>();
    private Date checkOutDate;
    private Date dueDate;

    final int RECALL_TIME = 3;

    public Book addClassification(BookClassification label, Object data){
        classifications.put(label,data);
        return this;
    }



    public Date getDueDate(){
        return dueDate;
    }


    public void setDueDate(Date set){
        dueDate = set;
    }




    public Object getClassification(BookClassification bookClass){
        return classifications.get(bookClass);
    }



    public Date checkOut(Date currentDate, int lengthOfCheckOut){
        if(checkOutDate != null)
            return null;
        else{
            checkOutDate = new Date(currentDate);
            dueDate = new Date(checkOutDate);
            dueDate.changeDate(lengthOfCheckOut);
            Message parcel = Message.NOT_OWNER;
            parcel.book = this;
            notifyObservers(parcel);
            return dueDate;
        }
    }


    public void changeCheckOutDate(Date newDate){
        checkOutDate = new Date(newDate);
    }


    public boolean recall(Date currentDate){
        if(!(isCheckedIn())){
            dueDate = (new Date(currentDate)).changeDate(RECALL_TIME);
            Message parcel = Message.OWNER;
            parcel.book = this;
            parcel.message = dueDate.stringForm();
            setChanged();
            notifyObservers(parcel);

            return true;
        } else {
            return false;
        }


    }

    public boolean isCheckedIn(){
        return (checkOutDate == null);
    }





    public boolean checkIn(){
        checkOutDate = null;
        dueDate = null;
        setChanged();
        Message parcel = Message.NOT_OWNER;
        parcel.book = this;
        setChanged();
        notifyObservers(parcel);
        return true;
    }



    public String getFullCode(){
        String code;
        code = getClassification(BookClassification.mainClassification).toString();
        code = code.concat(".");
        code = code.concat(getClassification(BookClassification.SubClassification).toString());
        code = code.concat(".");
        code = code.concat(getClassification(BookClassification.Serial_Number).toString());
        code = code.concat(":");
        code = code.concat(getClassification(BookClassification.Copy_Number).toString());

        return code;
    }


    public void addWatcher(User watcher){
        addObserver(watcher);

    }

    public void removeWatcher(User watcher){
        deleteObserver(watcher);

    }


    public void printBookData(){
        BookClassification lastItem = BookClassification.lastStableItem();
        System.out.println("----------");
        for (BookClassification classification = BookClassification.firstItem(); classification != lastItem; classification = classification.next(classification)){
            System.out.println(classification + ": " + classifications.get(classification));
        }



    }



    public boolean sameSpec(Book book){
        BookClassification lastItem = BookClassification.lastStableItem();

        if(lastItem != BookClassification.Copy_Number && !(classifications.get(lastItem).equals(book.getClassification(lastItem))))
            return false;

        for (BookClassification classification = BookClassification.firstItem(); classification != lastItem; classification = classification.next(classification)){
            if(classification != BookClassification.Copy_Number && !(classifications.get(classification).equals(book.getClassification(classification))))
                return false;

        }

        return true;

    }




}
