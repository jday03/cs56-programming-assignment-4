/**
 * Created by JonathanDay4 on 3/15/2017.
 */
public class main {

    static BookClassification addMagicNumber(BookClassification label){
        label = label.next(label);
        return label;

    }

    public static void main(String [] args){
        BookClassification sub = BookClassification.mainClassification;
        addMagicNumber(sub);
        System.out.println(sub);
    }
}
