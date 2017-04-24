package com.vertex.academy.enums;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import static com.vertex.academy.enums.WeekDays.*;

/**
 * Created by sweet_home on 18.02.17.
 */
public class TestEnums {

    public static String whatADay(WeekDays day) {
        String toReturn = "";
        switch (day) {
            case MONDAY:
            case TUESDAY:
            case THURSDAY:
            case WEDNESDAY: {
                toReturn = "not so good";
                break;
            }
            case FRIDAY:
            case SUNDAY:
            case SATURDAY: {
                toReturn = "a great day";
                break;
            }

        }

        return toReturn;
    }

    public static String whatADay(String dayName) {
        return WeekDays.valueOf(dayName.toUpperCase()).getKindOfDay();
    }


    public static void main(String[] args) {
//        Arrays.stream(WeekDays.values()).forEach(System.out::println);
//
//        System.out.println(SUNDAY + " is " +whatADay("sunday") + " " + SUNDAY.name() + ", " + SUNDAY.toString());
//        System.out.println(MONDAY + " is " +whatADay(MONDAY));
//
//        System.out.println(MONDAY.ordinal());

        EnumSet<WeekDays> initialSet = EnumSet.range(TUESDAY, THURSDAY);
        System.out.println(initialSet);

        List<WeekDays> days = Arrays.asList(TUESDAY, WEDNESDAY, THURSDAY);
        EnumSet<WeekDays> secondEnum = EnumSet.copyOf(days);
        EnumSet<WeekDays> thirdEnum = EnumSet.copyOf(secondEnum);

        System.out.println(secondEnum);
        System.out.println(thirdEnum);
    }
}
