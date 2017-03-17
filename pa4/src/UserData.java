/**
 * Created by JonathanDay4 on 3/15/2017.
 */
public enum UserData {
    ID,PIN, Name,Email, Phone_Number, Blocked, Return_Time_Limit, Books_At_A_Time_Limit;

    final static int ELEMENTS_NOT_STABLE= 3;

    public static UserData next (UserData current){
        UserData [] values = current.values();

        if(current == lastStableItem())
            return values[0];
        else return values[current.ordinal() + 1];

    }

    public static UserData lastStableItem(){
        return values()[values().length - (ELEMENTS_NOT_STABLE + 1)];

    }

    public static UserData firstItem(){
        return values()[0];
    }


}
