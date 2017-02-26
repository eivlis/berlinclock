package com.hotels.silvievyhnankova.berlinclock.presenter;


import com.hotels.silvievyhnankova.berlinclock.service.BerlinClockBuilder;
import com.hotels.silvievyhnankova.berlinclock.model.BerlinClock;
import com.hotels.silvievyhnankova.berlinclock.model.Lamp;

/**
 * represent a multiline String visualization of Berlin Clock
 * - yellow lamp turned on = Y
 * - red lamp turned on = R
 * - lamp turned off (yellow or red) = 0
 */
public class BerlinClockStringPresenterImpl implements BerlinClockPresenter<String> {

    @Override
    public String display(int hrs, int min, int sec) {
        BerlinClock berlinClock = new BerlinClockBuilder().build(hrs, min, sec);
        return display(berlinClock);
    }

    private String display(BerlinClock berlinClock) {
        StringBuilder sb = new StringBuilder();
        sb.append(displayLamp(berlinClock.getSecLamp()));
        sb.append('\n');
        sb.append(displayLampsInRow(berlinClock.getFiveHrsLamps()));
        sb.append('\n');
        sb.append(displayLampsInRow(berlinClock.getOneHrLamps()));
        sb.append("\n");
        sb.append(displayLampsInRow(berlinClock.getFiveMinLamps()));
        sb.append("\n");
        sb.append(displayLampsInRow(berlinClock.getOneMinLamps()));
        return sb.toString();
    }

    private String displayLampsInRow(Lamp[] lamps) {
        StringBuilder sb = new StringBuilder();
        for (Lamp lamp : lamps) {
            sb.append(displayLamp(lamp));
        }
        return sb.toString();
    }

    private String displayLamp(Lamp lamp) {
        Lamp.Status status = lamp.getStatus();
        switch (status) {
            case YELLOW_ON:
                return "Y";
            case RED_ON:
                return "R";
            case OFF:
                return "0";
        }

        throw new IllegalArgumentException(String.format("Unknown status %s", status.name()));
    }
}
