package com.hotels.silvievyhnankova.berlinclock

import spock.lang.Specification


class MainUnitSpec extends Specification{

    def "def execute with valid arguments"() {
        expect:
        String[] args = ["20", "20", "20"]
        Main.main(args)
    }

    def "execute without arguments"() {
        when:
        String[] args = []
        Main.main(args)

        then:
        thrown(IllegalArgumentException)
    }

    def "execute with not nimeric argument"() {
        when:
        String[] args = ["a", "3", "30"]
        Main.main(args)

        then:
        thrown(IllegalArgumentException)
    }
}
