import spock.lang.*

class BabysitterTest extends Specification {

    @Unroll
    def "babysitter gets paid twelve dollars for each hour of work before bedtime"() {
        expect:
            Babysitter.calculatePay(startTime, endTime, bedTime) == payment

        where:
            startTime | endTime | bedTime | payment
            5         | 6       | 9       | 12
            5         | 7       | 9       | 24
            5         | 8       | 9       | 36
    }

    @Unroll
    def "babysitter gets paid eight dollars for each hour after bedtime before midnight"() {
        expect:
            Babysitter.calculatePay(startTime, endTime, bedTime) == payment

        where:
            startTime | endTime | bedTime | payment
            8         | 9       | 7       | 8
            8         | 10      | 7       | 16
            8         | 11      | 7       | 24
    }

    def "babysitter gets paid twelve dollars before bedtime and eight dollars after bedtime before midnight"() {
        when:
            def payment = Babysitter.calculatePay(7, 9, 8)

        then:
            payment == 20
    }

    @Unroll
    def "babysitter gets paid sixteen dollars after midnight"() {
        expect:
            Babysitter.calculatePay(startTime, endTime, bedTime) == payment

        where:
            startTime | endTime | bedTime | payment
            12        | 13       | 9       | 16
            12        | 14       | 9       | 32
            12        | 15       | 9       | 48
    }

    def "babysitter gets paid eight dollars between bedtime and midnight and sixteen dollars after midnight"() {
        when:
            def payment = Babysitter.calculatePay(11, 13, 8)

        then:
            payment == 24
    }

    def "stuff"() {
        when:
            def payment = Babysitter.calculatePay(8, 13, 10)

        then:
            payment == (24 + 16 + 16)
    }
}