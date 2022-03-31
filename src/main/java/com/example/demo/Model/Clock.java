package com.example.demo.Model;

import java.time.LocalDateTime;

public class Clock {
    private int hour;
    private int minute;
    private static final String[] humanText = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
            "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"
    };

    public Clock(String clockString){
        String[] splitTime = clockString.trim().split(":");
        this.hour = Integer.parseInt(splitTime[0]);
        this.minute = Integer.parseInt(splitTime[1]);
    }

    public Clock(LocalDateTime localDateTime){
        this.hour = localDateTime.getHour();
        this.minute = localDateTime.getMinute();
    }

    public static boolean validate(String input){
        if(input.isEmpty() || !input.contains(":")) return false;

        String[] splitTime = input.trim().split(":");
        if(splitTime.length != 2 || splitTime[1].length() != 2) return false;
        try{
            int tempHour = Integer.parseInt(splitTime[0]);
            int tempTime = Integer.parseInt(splitTime[1]);
            if(tempHour < 0 || tempHour >= 24 || tempTime < 0 || tempTime >= 60)
                return false;
        } catch (NumberFormatException exception){
            return false;
        }
        return true;
    }

    public String capitalizeFirstString(String str) {
        if(str == null || str.isEmpty())
            return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    @Override
    public String toString(){
        String converted;
        hour = hour % 12 == 0 ? 12 : hour % 12;
        if (minute == 0)
            converted = humanText[hour] + " o'clock";
        else if (minute == 15)
            converted = "quarter past " + humanText[hour];
        else if (minute == 30)
            converted = "half past " + humanText[hour];
        else if (minute == 45)
            converted = "quarter to " + humanText[(hour % 12) + 1];
        else if (minute < 30)
            converted = humanText[minute] + " past " + humanText[hour];
        else
            converted = humanText[60 - minute] + " to " + humanText[(hour % 12) + 1];
        return capitalizeFirstString(converted);
    }
}
