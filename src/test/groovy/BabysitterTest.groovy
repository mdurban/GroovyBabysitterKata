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
            10        | 11      | 9       | 8
            10        | 12      | 9       | 16
            10        | 13      | 9       | 24
    }
}