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
            return null;
        }
    }


    public void changeCheckOutDate(Date newDate){
        checkOutDate = new Date(newDate);
    }


    public boolean recall(Date currentDate){
        if(!(isCheckedIn())){
            dueDate = (new Date(currentDate)).changeDate(RECALL_TIME);
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
        notifyObservers(getFullCode());
        return true;
    }

    public String getFullCode(){
        String code;
        code = getClassification(BookClassification.mainClassification).toString();
        code.concat(".");
        code.concat(getClassification(BookClassification.SubClassification).toString());
        code.concat(".");
        code.concat(getClassification(BookClassification.Serial_Number).toString());
        code.concat(":");
        code.concat(getClassification(BookClassification.Copy_Number).toString());

        return code;
    }


    public void addWatcher(User watcher){
        addObserver(watcher);

    }




}
