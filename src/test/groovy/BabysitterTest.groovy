import spock.lang.Specification

class BabysitterTest extends Specification {

    def "babysitter gets paid twelve dollars for each hour of work before bedtime"() {
        expect:
            Babysitter.startJob(startTime, endTime, bedTime) == payment

        where:
            startTime | endTime | bedTime | payment
            5         | 6       | 9       | 12
            5         | 7       | 9       | 24
            5         | 8       | 9       | 36
    }
    
    def "babysitter gets paid eight dollars after bedtime before midnight"() {
        given:
        def hourOfPay = Babysitter.startJob(10, 11, 9)

        expect:
        hourOfPay == 8
    }
}