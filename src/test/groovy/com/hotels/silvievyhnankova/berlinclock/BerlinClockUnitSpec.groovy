package com.hotels.silvievyhnankova.berlinclock

import com.hotels.silvievyhnankova.berlinclock.service.BerlinClockBuilder
import com.hotels.silvievyhnankova.berlinclock.model.BerlinClock

import com.hotels.silvievyhnankova.berlinclock.model.Lamp
import com.hotels.silvievyhnankova.berlinclock.model.Time
import spock.lang.Specification

class BerlinClockUnitSpec extends Specification {

    private final static String MIDNIGHT = "00:00:00"

    def "test seconds lamp should be turned on and yellow colour"() {
        when:
        Lamp secondLamp = getSecondsLamp(time)

        then:
        secondLamp.getStatus() == Lamp.Status.YELLOW_ON

        where:
        time       | _
        "00:00:00" | _
        "00:00:32" | _
        "00:09:46" | _
        "07:10:58" | _
    }

    def "test seconds lamp should be turned off"() {
        when:
        Lamp secondLamp = getSecondsLamp(time)

        then:
        secondLamp.getStatus() == Lamp.Status.OFF

        where:
        time       | _
        "00:00:01" | _
        "00:00:33" | _
        "00:09:47" | _
        "07:10:59" | _
    }

    def "test five hours lamps should be 4"() {
        when:
        Lamp[] fiveHoursLamps = getFiveHoursLamps(MIDNIGHT)

        then:
        fiveHoursLamps.length == 4
    }

    def "test five hours lamps should be all turned off"() {
        when:
        Lamp[] fiveHoursLamps = getFiveHoursLamps(time)

        then:
        test(fiveHoursLamps as List, 0)

        where:
        time       | _
        "00:00:00" | _
        "01:00:00" | _
        "02:00:00" | _
        "03:00:00" | _
        "04:00:00" | _
        "04:59:59" | _
    }

    def "test five hours lamps should be first one turned on"() {
        when:
        Lamp[] fiveHoursLamps = getFiveHoursLamps(time)

        then:
        test(fiveHoursLamps as List, 1)

        where:
        time       | _
        "05:00:00" | _
        "06:00:00" | _
        "07:00:00" | _
        "08:00:00" | _
        "09:00:00" | _
        "09:59:59" | _
    }

    def "test five hours lamps should be first two turned on"() {
        when:
        Lamp[] fiveHoursLamps = getFiveHoursLamps(time)

        then:
        test(fiveHoursLamps as List, 2)

        where:
        time       | _
        "10:00:00" | _
        "11:00:00" | _
        "12:00:00" | _
        "13:00:00" | _
        "14:00:00" | _
        "14:59:59" | _
    }

    def "test five hours lamps should be first three turned on"() {
        when:
        Lamp[] fiveHoursLamps = getFiveHoursLamps(time)

        then:
        test(fiveHoursLamps as List, 3)

        where:
        time       | _
        "15:00:00" | _
        "16:00:00" | _
        "17:00:00" | _
        "18:00:00" | _
        "19:00:00" | _
        "19:59:59" | _
    }

    def "test five hours lamps should be all turned on"() {
        when:
        Lamp[] fiveHoursLamps = getFiveHoursLamps(time)

        then:
        test(fiveHoursLamps as List, 4)

        where:
        time       | _
        "20:00:00" | _
        "21:00:00" | _
        "22:00:00" | _
        "23:00:00" | _
        "23:59:59" | _
    }

    def "test one hour lamps should be 4"() {
        when:
        Lamp[] oneHourLamps = getOneHourLamps(MIDNIGHT)

        then:
        oneHourLamps.length == 4
    }

    def "test one hour lamps should be all turned off"() {
        when:
        Lamp[] oneHourLamps = getOneHourLamps(time)

        then:
        test(oneHourLamps as List, 0)

        where:
        time       | _
        "00:00:00" | _
        "05:00:00" | _
        "10:00:00" | _
        "15:00:00" | _
        "20:00:00" | _
        "20:59:59" | _
    }

    def "test one hour lamps should be first one turned on"() {
        when:
        Lamp[] oneHourLamps = getOneHourLamps(time)

        then:
        test(oneHourLamps as List, 1)

        where:
        time       | _
        "01:00:00" | _
        "06:00:00" | _
        "11:00:00" | _
        "16:00:00" | _
        "21:00:00" | _
        "21:59:59" | _
    }

    def "test one hour lamps should be first two turned on"() {
        when:
        Lamp[] oneHourLamps = getOneHourLamps(time)

        then:
        test(oneHourLamps as List, 2)

        where:
        time       | _
        "02:00:00" | _
        "07:00:00" | _
        "12:00:00" | _
        "17:00:00" | _
        "22:00:00" | _
        "22:59:59" | _
    }

    def "test one hour lamps should be first three turned on"() {
        when:
        Lamp[] oneHourLamps = getOneHourLamps(time)

        then:
        test(oneHourLamps as List, 3)

        where:
        time       | _
        "03:00:00" | _
        "08:00:00" | _
        "13:00:00" | _
        "18:00:00" | _
        "23:00:00" | _
        "23:59:59" | _
    }

    def "test one hour lamps should be all turned on"() {
        when:
        Lamp[] oneHourLamps = getOneHourLamps(time)

        then:
        test(oneHourLamps as List, 4)

        where:
        time       | _
        "04:00:00" | _
        "09:00:00" | _
        "14:00:00" | _
        "19:00:00" | _
        "19:59:59" | _
    }

    def "test five minutes lamps should be 11"() {
        when:
        Lamp[] fiveMinutesLamps = getFiveMinutesLamps(MIDNIGHT)

        then:
        fiveMinutesLamps.length == 11
    }

    def "test five minutes lamps should be first one turned on"() {
        when:
        Lamp[] fiveMinutesLamps = getFiveMinutesLamps(time)

        then:
        test(fiveMinutesLamps as List, 1)

        where:
        time       | _
        "00:05:00" | _
        "00:06:00" | _
        "00:07:00" | _
        "00:08:00" | _
        "00:09:00" | _
        "00:09:59" | _
    }

    def "test five minutes lamps should be first three turned on"() {
        when:
        Lamp[] fiveMinutesLamps = getFiveMinutesLamps(time)

        then:
        test(fiveMinutesLamps as List, 3)

        where:
        time       | _
        "00:15:00" | _
        "00:16:00" | _
        "00:17:00" | _
        "00:18:00" | _
        "00:19:00" | _
        "00:19:59" | _
    }

    def "test five minutes lamps should be all turned on"() {
        when:
        Lamp[] fiveMinutesLamps = getFiveMinutesLamps(time)

        then:
        test(fiveMinutesLamps as List, 11)

        where:
        time       | _
        "00:55:00" | _
        "00:56:00" | _
        "00:57:00" | _
        "00:58:00" | _
        "00:59:00" | _
        "00:59:59" | _
    }

    def "test one minute lamps should be 4"() {
        when:
        Lamp[] oneMinuteLamps = getOneMinuteLamps(MIDNIGHT)

        then:
        oneMinuteLamps.length == 4
    }

    def "test one minute lamps should be all turned off"() {
        when:
        Lamp[] oneMinuteLamps = getOneMinuteLamps(time)

        then:
        test(oneMinuteLamps as List, 0)

        where:
        time       | _
        "00:00:00" | _
        "00:05:00" | _
        "00:10:00" | _
        "00:15:00" | _
        "00:20:00" | _
        "00:25:00" | _
        "00:30:00" | _
        "00:35:00" | _
        "00:40:00" | _
        "00:45:00" | _
        "00:50:00" | _
        "00:55:00" | _
    }

    def "test one minute lamps should be first one turned on"() {
        when:
        Lamp[] oneMinuteLamps = getOneMinuteLamps(time)

        then:
        test(oneMinuteLamps as List, 1)

        where:
        time       | _
        "00:01:00" | _
        "00:06:00" | _
        "00:11:00" | _
        "00:16:00" | _
        "00:21:00" | _
        "00:26:00" | _
        "00:31:00" | _
        "00:36:00" | _
        "00:41:00" | _
        "00:46:00" | _
        "00:51:00" | _
        "00:56:00" | _
    }

    def "test one minute lamps should be first two turned on"() {
        when:
        Lamp[] oneMinuteLamp = getOneMinuteLamps(time)

        then:
        test(oneMinuteLamp as List, 2)

        where:
        time       | _
        "00:02:00" | _
        "00:07:00" | _
        "00:12:00" | _
        "00:17:00" | _
        "00:22:00" | _
        "00:27:00" | _
        "00:32:00" | _
        "00:37:00" | _
        "00:42:00" | _
        "00:47:00" | _
        "00:52:00" | _
        "00:57:00" | _
    }

    def "test one minute lamps should be first three turned on"() {
        when:
        Lamp[] oneMinuteLamps = getOneMinuteLamps(time)

        then:
        test(oneMinuteLamps as List, 3)

        where:
        time       | _
        "00:03:00" | _
        "00:08:00" | _
        "00:13:00" | _
        "00:18:00" | _
        "00:23:00" | _
        "00:28:00" | _
        "00:33:00" | _
        "00:38:00" | _
        "00:43:00" | _
        "00:48:00" | _
        "00:53:00" | _
        "00:58:00" | _
    }

    def "test one minute lamps should be all turned on"() {
        when:
        Lamp[] oneMinuteLamps = getOneMinuteLamps(time)

        then:
        test(oneMinuteLamps as List, 4)

        where:
        time       | _
        "00:04:00" | _
        "00:09:00" | _
        "00:14:00" | _
        "00:19:00" | _
        "00:24:00" | _
        "00:29:00" | _
        "00:34:00" | _
        "00:39:00" | _
        "00:44:00" | _
        "00:49:00" | _
        "00:54:00" | _
        "00:59:00" | _
    }

    boolean test(List<Lamp> lamps, int onCount) {
        boolean isOn = lamps.subList(0, onCount).stream().allMatch({ it.getStatus() != Lamp.Status.OFF })
        if(isOn) return lamps.subList(onCount, lamps.size()).stream().allMatch({ it.getStatus() == Lamp.Status.OFF })

        return false
    }


    def buildBerlinClock(String time) {
        BerlinClockBuilder berlinClockBuilder = new BerlinClockBuilder()
        berlinClockBuilder.build(parseTime(time))
    }

    def getSecondsLamp(String time) {
        BerlinClock berlinClock = buildBerlinClock(time)
        berlinClock.getSecLamp()
    }

    def getFiveHoursLamps(String time) {
        BerlinClock berlinClock = buildBerlinClock(time)
        berlinClock.getFiveHrsLamps()
    }

    def getOneHourLamps(String time) {
        BerlinClock berlinClock = buildBerlinClock(time)
        berlinClock.getOneHrLamps()
    }

    def getFiveMinutesLamps(String time) {
        BerlinClock berlinClock = buildBerlinClock(time)
        berlinClock.getFiveMinLamps()
    }

    def getOneMinuteLamps(String time) {
        BerlinClock berlinClock = buildBerlinClock(time)
        berlinClock.getOneMinLamps()
    }

    def parseTime(String time) {
        String[] timeFragments = time.split(":")
        return Time.of(Integer.valueOf(timeFragments[0]), Integer.valueOf(timeFragments[1]), Integer.valueOf(timeFragments[2]))
    }


}
