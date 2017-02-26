package com.hotels.silvievyhnankova.berlinclock

import com.hotels.silvievyhnankova.berlinclock.model.Time
import com.hotels.silvievyhnankova.berlinclock.presenter.BerlinClockStringPresenterImpl
import spock.lang.Specification

class BerlinClockVizualizerUnitSpec extends Specification {

    def "display Berlin clock"() {
        when:
        def stringVisualizerImpl = new BerlinClockStringPresenterImpl()
        String result = stringVisualizerImpl.display(time.getHrs(), time.getMin(), time.getSec())

        then:
        result == expectedResult

        where:
        time                | expectedResult
        Time.of(0, 0, 0)    | "Y\n0000\n0000\n00000000000\n0000"
        Time.of(23, 59, 59) | "0\nRRRR\nRRR0\nYYRYYRYYRYY\nYYYY"
        Time.of(1, 1, 1)    | "0\n0000\nR000\n00000000000\nY000"
        Time.of(10, 15, 30) | "Y\nRR00\n0000\nYYR00000000\n0000"

    }

    def "test invalid time should throw an IllegalArgumentException"() {
        when:
        def stringVisualizerImpl = new BerlinClockStringPresenterImpl()
        stringVisualizerImpl.display(hrs, min, sec)

        then:
        thrown(IllegalArgumentException.class)

        where:
        hrs | min | sec
        24  | 0   | 0
        0   | 60  | 0
        0   | 0   | 60
    }
}
