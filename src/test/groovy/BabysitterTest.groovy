import spock.lang.*

class BabysitterTest extends Specification {

    private static final def PRE_BEDTIME_PAY = 12
    private static final def PRE_MIDNIGHT_PAY = 8
    private static final def POST_MIDNIGHT_PAY = 16

    @Unroll
    def "babysitter gets paid twelve dollars for each hour of work before bedtime"() {
        expect:
            Babysitter.calculatePay(startTime, endTime, bedTime) == payment

        where:
            startTime | endTime | bedTime | payment
            5         | 6       | 9       | PRE_BEDTIME_PAY
            5         | 7       | 9       | 2*PRE_BEDTIME_PAY
            5         | 8       | 9       | 3*PRE_BEDTIME_PAY
    }

    @Unroll
    def "babysitter gets paid eight dollars for each hour after bedtime before midnight"() {
        expect:
            Babysitter.calculatePay(startTime, endTime, bedTime) == payment

        where:
            startTime | endTime | bedTime | payment
            8         | 9       | 7       | PRE_MIDNIGHT_PAY
            8         | 10      | 7       | 2*PRE_MIDNIGHT_PAY
            8         | 11      | 7       | 3*PRE_MIDNIGHT_PAY
    }

    def "babysitter gets paid twelve dollars before bedtime and eight dollars after bedtime before midnight"() {
        when:
            def payment = Babysitter.calculatePay(7, 9, 8)

        then:
            payment == PRE_BEDTIME_PAY + PRE_MIDNIGHT_PAY
    }

    @Unroll
    def "babysitter gets paid sixteen dollars after midnight"() {
        expect:
            Babysitter.calculatePay(startTime, endTime, bedTime) == payment

        where:
            startTime | endTime | bedTime | payment
            12        | 13       | 9       | POST_MIDNIGHT_PAY
            12        | 14       | 9       | 2*POST_MIDNIGHT_PAY
            12        | 15       | 9       | 3*POST_MIDNIGHT_PAY
    }

    def "babysitter gets paid eight dollars between bedtime and midnight and sixteen dollars after midnight"() {
        when:
            def payment = Babysitter.calculatePay(11, 13, 8)

        then:
            payment == PRE_MIDNIGHT_PAY + POST_MIDNIGHT_PAY
    }

    @Unroll
    def "babysitter gets paid twelve dollars before bedtime, eight dollars before midnight, and sixteen dollars after midnight"() {
        expect:
        Babysitter.calculatePay(startTime, endTime, bedTime) == payment

        where:
            startTime | endTime | bedTime | payment
            8         | 13       | 10     | 2*PRE_BEDTIME_PAY + 2*PRE_MIDNIGHT_PAY + POST_MIDNIGHT_PAY
            7         | 14       | 10     | 3*PRE_BEDTIME_PAY + 2*PRE_MIDNIGHT_PAY + 2*POST_MIDNIGHT_PAY
            6         | 15       | 10     | 4*PRE_BEDTIME_PAY + 2*PRE_MIDNIGHT_PAY + 3*POST_MIDNIGHT_PAY
    }
}