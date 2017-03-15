/**
 * Created by JonathanDay4 on 3/15/2017.
 */
public enum BookClassification {
    a,b,c,d,e,f;

    public BookClassification next(BookClassification current){
        BookClassification [] values = BookClassification.values();
        int size = values.length;
        int currentPosition =  current.ordinal();
        if(size == currentPosition)
           return values[0];
        else return values[current.ordinal() + 1];

    }
}
