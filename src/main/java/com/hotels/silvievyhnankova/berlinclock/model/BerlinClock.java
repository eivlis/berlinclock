package com.hotels.silvievyhnankova.berlinclock.model;

import java.util.function.Supplier;

public class BerlinClock {

    private final Lamp secLamp;
    private final Lamp[] fiveHrsLamps;
    private final Lamp[] oneHrLamps;
    private final Lamp[] fiveMinLamps;
    private final Lamp[] oneMinLamps;

    private BerlinClock(Lamp secLamp, Lamp[] fiveHrsLamps, Lamp[] oneHrLamps, Lamp[] fiveMinLamps, Lamp[] oneMinLamps) {
        this.secLamp = secLamp;
        this.fiveHrsLamps = fiveHrsLamps;
        this.oneHrLamps = oneHrLamps;
        this.fiveMinLamps = fiveMinLamps;
        this.oneMinLamps = oneMinLamps;
    }

    public Lamp getSecLamp() {
        return secLamp;
    }

    public Lamp[] getFiveHrsLamps() {
        return fiveHrsLamps;
    }

    public Lamp[] getOneHrLamps() {
        return oneHrLamps;
    }

    public Lamp[] getFiveMinLamps() {
        return fiveMinLamps;
    }

    public Lamp[] getOneMinLamps() {
        return oneMinLamps;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder implements Supplier<BerlinClock> {

        private Lamp secLamp;
        private Lamp[] fiveHrsLamps;
        private Lamp[] oneHrLamps;
        private Lamp[] fiveMinLamps;
        private Lamp[] oneMinLamps;

        public Builder withSecLamp(Lamp secLamp) {
            this.secLamp = secLamp;
            return this;
        }

        public Builder withFiveHrsLamps(Lamp[] fiveHrsLamps) {
            this.fiveHrsLamps = fiveHrsLamps;
            return this;
        }

        public Builder withOneHrLamps(Lamp[] oneHrLamps) {
            this.oneHrLamps = oneHrLamps;
            return this;
        }

        public Builder withFiveMinLamps(Lamp[] fiveMinLamps) {
            this.fiveMinLamps = fiveMinLamps;
            return this;
        }

        public Builder withOneMinLamps(Lamp[] oneMinLamps) {
            this.oneMinLamps = oneMinLamps;
            return this;
        }

        @Override
        public BerlinClock get() {
            if (secLamp == null) throw new NullPointerException("sec lamp is null");
            if (fiveHrsLamps == null) throw new NullPointerException("five hours lamps array is null");
            if (oneHrLamps == null) throw new NullPointerException("one hour lamps array is null");
            if (fiveMinLamps == null) throw new NullPointerException("five minutes array lamps is null");
            if (oneMinLamps == null) throw new NullPointerException("one minute lamps array is null");
            return new BerlinClock(secLamp, fiveHrsLamps, oneHrLamps, fiveMinLamps, oneMinLamps);
        }
    }
}
