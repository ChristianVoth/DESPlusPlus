package core;

import java.sql.Time;
import java.util.GregorianCalendar;

public class TimeHandler {

    private GregorianCalendar startDate;
    private GregorianCalendar dateToSchedule;

    private double differenceInSeconds;




    public int calculateDifference(GregorianCalendar startDate, GregorianCalendar date){

        long difference = date.getTimeInMillis() - startDate.getTimeInMillis();

        System.out.println(difference);

        int differenceInSeconds = (int) (difference / 1000);

        System.out.println(differenceInSeconds);
        return differenceInSeconds;


    }

    public double getDifferenceInSeconds(){
        return differenceInSeconds;
    }

}
