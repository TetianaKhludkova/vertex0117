package com.vertex.academy.enums;

/**
 * Created by sweet_home on 18.02.17.
 */
public enum WeekDays {
    MONDAY("not so good"),
    TUESDAY("not so good"),
    WEDNESDAY("not so good"),
    THURSDAY("not so good"),
    FRIDAY("party day"),
    SATURDAY("course day"),
    SUNDAY("day to sleep");

    private String whatADay;

    WeekDays(String whatADay) {
        this.whatADay = whatADay;
    }

    public String getKindOfDay() {
        return whatADay;
    }
}
