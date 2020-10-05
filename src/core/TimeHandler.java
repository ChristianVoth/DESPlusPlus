package core;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.time.*;

public class TimeHandler {

    private GregorianCalendar startDate;
    private GregorianCalendar dateToSchedule;

    private double differenceInSeconds;

    Instant timeInstant =  Instant.now();
    ZonedDateTime zdt = ZonedDateTime.ofInstant(timeInstant, ZoneId.systemDefault());
    GregorianCalendar cal = GregorianCalendar.from(zdt);




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
