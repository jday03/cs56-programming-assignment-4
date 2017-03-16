/**
 * Created by JonathanDay4 on 3/15/2017.
 */
public enum BookClassification {
    mainClassification,SubClassification,Serial_Number,Title,Author,Publisher,Year_Of_Publication, Copy_Number,Checked_Out_Date;

    public BookClassification next(BookClassification current){
        BookClassification [] values = BookClassification.values();
        int size = values.length;
        int currentPosition =  current.ordinal();
        if(size == currentPosition)
           return values[0];
        else return values[current.ordinal() + 1];

    }

    public static BookClassification lastStableItem(){
        return values()[values().length - 2];

    }

}
