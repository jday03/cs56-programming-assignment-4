/**
 * Created by JonathanDay4 on 3/16/2017.
 */
public class Date {
    int [] date = new int[3];


    private final static int [] calendar = {31,28,31,30,31,30,31,31,30,31,30,31};

    public Date(){
        update(1,1,1);
    }

    public Date(int year, int month, int day){
        update(year,month,day);
    }

    public Date(Date another){
        date[0] = another.date[0];
        date[1] = another.date[1];
        date[2] = another.date[2];

    }


    public void update(int year, int month, int day){
        date[0] = year;
        date[1] = month;
        date[2] = day;
    }

    public Date changeDate(int days){
        for( ; days < 0; days++) {
            if(date[2] == 0) {
                date[1] --;
                if(date[1] == 0) {
                    date[1] = 12;
                    date[0]--;
                }
                date[2] = calendar[date[1] - 1];
            }
        }

        for(; days > 0; days --){
            if(date[2] == calendar[date[1]-1]) {

                if(date[1] == 12) {
                    date[1] = 1;
                    date[0]++;
                }
                else {
                    date[1]++;

                }
                date[2] = 1;
            }

        }
        return this;
    }

    public void print(){
        System.out.println(date[0] + " / "+ date[1] + " / " + date[2]);
    }

}
