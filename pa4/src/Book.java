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
        //Observers tho.
        return true;
    }
}
