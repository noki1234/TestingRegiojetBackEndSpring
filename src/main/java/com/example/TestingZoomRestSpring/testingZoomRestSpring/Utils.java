package com.example.TestingZoomRestSpring.testingZoomRestSpring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import static java.time.LocalDate.now;

public class Utils {

    private static Utils instance;

    private Utils(){}

    public static Utils getInstance(){
        if (instance == null){
            instance = new Utils();
        }
        return instance;
    }

    public LocalDate getNearestDayFromCalendar(DayOfWeek day){
        LocalDate date = now();
        while (date.getDayOfWeek() != day){
            date = date.plusDays(1);
        }
        return date;
    }


    public Date getDateFromTime(String timeString){
        try {
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
            return parser.parse(timeString);
        }catch (ParseException exception){
            exception.printStackTrace();
        }
        return null;
    }


    public Date extractTimeFromDate(Date date){
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
        try {
            return formater.parse(formater.format(date));
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

}
