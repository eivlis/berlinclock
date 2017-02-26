package com.hotels.silvievyhnankova.berlinclock.service;


import com.hotels.silvievyhnankova.berlinclock.model.BerlinClock;
import com.hotels.silvievyhnankova.berlinclock.model.Lamp;
import com.hotels.silvievyhnankova.berlinclock.model.Time;

/**
 *  Class represent builder for Berlin Clock
 *  - The yellow top lamp is a pump which is blinking on/off every two seconds.
 *  - In the topmost line of red lamps every lamp represents 5 hours.
 *  - In the second line of red lamps every lamp represents 1 hour.
 *  - In the third line with tall lamps every lamp represents 5 minutes.
 *    There are 11 lamps, the 3rd, 6th, and 9th are red indicating the first quarter, half, and the last quarter of the hour.
 *  - In the last line with yellow lamps every lamp represents 1 minute.
 *
 */
public class BerlinClockBuilder {

    public BerlinClock build(int hrs, int min, int sec) {
        return build(Time.of(hrs, min, sec));
    }


    public BerlinClock build(Time time) {
        Lamp secLamp = getSecLamp(time.getSec());
        Lamp[] fiveHrsLamps = getFiveHrsLamps(time.getHrs());
        Lamp[] oneHrLamp = getOneHrLamps(time.getHrs());
        Lamp[] fiveMinLamps = getFiveMinLamps(time.getMin());
        Lamp[] oneMinLamps = getOneMinLamps(time.getMin());
        return BerlinClock.builder()
                .withSecLamp(secLamp)
                .withFiveHrsLamps(fiveHrsLamps)
                .withOneHrLamps(oneHrLamp)
                .withFiveMinLamps(fiveMinLamps)
                .withOneMinLamps(oneMinLamps)
                .get();
    }

    private Lamp getSecLamp(int sec) {
        boolean on = (sec % 2 == 0);
        return new Lamp(on ? Lamp.Status.YELLOW_ON : Lamp.Status.OFF);
    }

    private Lamp[] getFiveHrsLamps(int hour) {
        Lamp[] lamps = new Lamp[4];
        for (int i = 0; i < lamps.length; i++) {
            boolean on = (i < hour / 5) ? true : false;
            lamps[i] = new Lamp(on ? Lamp.Status.RED_ON : Lamp.Status.OFF);
        }
        return lamps;
    }

    private Lamp[] getOneHrLamps(int hour) {
        Lamp[] lamps = new Lamp[4];
        for (int i = 0; i < lamps.length; i++) {
            boolean on = (i < hour % 5) ? true : false;
            lamps[i] = new Lamp(on ? Lamp.Status.RED_ON : Lamp.Status.OFF);
        }
        return lamps;
    }

    private Lamp[] getFiveMinLamps(int minute) {
        Lamp[] lamps = new Lamp[11];
        for (int i = 0; i < lamps.length; i++) {
            boolean on = (i < minute / 5) ? true : false;
            Lamp.Status statusOn = ((i + 1) % 3 == 0) ? Lamp.Status.RED_ON : Lamp.Status.YELLOW_ON;
            lamps[i] = new Lamp(on ? statusOn : Lamp.Status.OFF);
        }
        return lamps;
    }

    private Lamp[] getOneMinLamps(int minute) {
        Lamp[] lamps = new Lamp[4];
        for (int i = 0; i < lamps.length; i++) {
            boolean on = (i < minute % 5) ? true : false;
            lamps[i] = new Lamp(on ? Lamp.Status.YELLOW_ON : Lamp.Status.OFF);
        }
        return lamps;
    }
}
