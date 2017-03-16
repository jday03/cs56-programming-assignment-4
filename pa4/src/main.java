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
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        int n = reader.nextInt();
        System.out.println(n);

        n = reader.nextInt();
        System.out.println(n);

        n = reader.nextInt();
        System.out.println(n);
    }
}
