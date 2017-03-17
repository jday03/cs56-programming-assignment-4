import java.util.Scanner;

/**
 * Created by JonathanDay4 on 3/15/2017.
 */
public class main {

    static BookClassification addMagicNumber(BookClassification label){
        label = label.next(label);
        return label;

    }

    public static void main(String [] args){
        Library test = new Library("./pa4/src/Library.data");
    }
}
