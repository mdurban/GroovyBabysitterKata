import spock.lang.Specification

class BabysitterTest extends Specification {

    def "babysitter gets paid twelve dollars for an hour of work before bedtime"() {
        given:
            def hourOfPay = Babysitter.startJob(5, 6, 9)

        expect:
            hourOfPay == 12
    }

    def "babysitter gets paid twenty-four dollars for two hours of work before bedtime"() {
        given:
            def hourOfPay = Babysitter.startJob(5, 7, 9)

        expect:
            hourOfPay == 24
    }
}