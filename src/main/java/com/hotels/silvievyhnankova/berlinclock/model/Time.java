package com.hotels.silvievyhnankova.berlinclock.model;


public class Time {

    private int hrs;
    private int min;
    private int sec;

    private Time(int hrs, int min, int sec) {
        if (hrs < 0 || hrs > 23) throw new IllegalArgumentException(String.format("Hour %s is not valid", hrs));
        if (min < 0 || min > 59) throw new IllegalArgumentException(String.format("Minute %s is not valid", min));
        if (sec < 0 || sec > 59) throw new IllegalArgumentException(String.format("Second %s is not valid", sec));
        this.hrs = hrs;
        this.min = min;
        this.sec = sec;
    }

    public static Time of(int hrs, int min, int sec) {
        return new Time(hrs, min, sec);
    }

    public int getHrs() {
        return hrs;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(hrs < 10) sb.append("0");
        sb.append(hrs);
        sb.append(":");
        if (min < 10) sb.append("0");
        sb.append(min);
        sb.append(":");
        if (sec < 10) sb.append("0");
        sb.append(sec);
        return sb.toString();
    }
}
