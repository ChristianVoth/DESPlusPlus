package core;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import java.time.*;

public class TimeHandler {

    private GregorianCalendar startDate;
    private GregorianCalendar dateToSchedule;

    private double differenceInSeconds;






    public int calculateDifference(Instant startDate, Instant date){


        long difference = ChronoUnit.SECONDS.between(startDate, date);



        System.out.println(difference);


        return (int) difference;


    }


}
