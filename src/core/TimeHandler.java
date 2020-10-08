package core;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import java.time.*;

public class TimeHandler {
    LogHandler myLog = new LogHandler();


    public int calculateDifference(Instant startDate, Instant date){
        long difference = 0;
        int compare = startDate.compareTo(date);

        if(compare < 0 ){
            myLog.logger.info("Your Date is greater than your startDate. startDate: " + startDate + " date: " + date);
        }

        try{
            difference = ChronoUnit.SECONDS.between(startDate, date);
        } catch (NullPointerException e){
            myLog.logger.info("You tried to pase in an null value. startDate: " + startDate + " date: " + date);
        } finally {
            return (int) difference;
        }










    }


}
