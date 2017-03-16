import org.omg.PortableServer.Current;

/**
 * Created by JonathanDay4 on 3/15/2017.
 */
public enum BookClassification {
    mainClassification,SubClassification,Serial_Number,Title,Author,Publisher,Year_Of_Publication, Copy_Number,Checked_Out_Date;

    final static int ELEMENTS_NOT_STABLE = 1;

    public BookClassification next(BookClassification current){
        BookClassification [] values = BookClassification.values();
        if(current == lastStableItem())
           return values[0];
        else return values[current.ordinal() + 1];

    }

    public static BookClassification lastStableItem(){
        return values()[values().length - (ELEMENTS_NOT_STABLE + 1)];

    }

    public static BookClassification firstItem(){
        return values()[0];
    }
}
