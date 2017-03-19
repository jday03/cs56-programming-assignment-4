package ProgAssignment4;

/**
 * Created by JonathanDay4 on 3/13/2017.
 */
public class UserFactory {



    public static User createUser(UserType occupation){

        switch(occupation){
            case STUDENT:
                return new Student();
            case GRADUATE_RESEARCHER:
                return new GraduateResearcher();
            case PROFESSOR:
                return new Professor();
            default:
                return null;
        }

    }



    public static User createUser(UserData data, String firstLine, User previousUser) {
        return previousUser.addClassification(data,firstLine);
    }







}