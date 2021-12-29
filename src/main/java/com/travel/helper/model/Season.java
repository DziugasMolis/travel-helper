package com.travel.helper.model;

import java.time.Month;

public enum Season {
    SPRING, SUMMER, FALL, WINTER;

    static public Season of(final Month month) {
        switch (month) {
            case MARCH:
            case APRIL:
            case MAY:
                return Season.SPRING;
            case JUNE:
            case JULY:
            case AUGUST:
                return Season.SUMMER;
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
                return Season.FALL;
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                return Season.WINTER;
            default:
                return null;
        }
    }
}
