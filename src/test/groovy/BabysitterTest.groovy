import spock.lang.Specification

class BabysitterTest extends Specification {

//    def "babysitter can start a job"() {
//        given:
//            def jobStarted = Babysitter.startJob(5, 10, 9)
//
//        expect:
//            jobStarted
//    }

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

    def "babysitter gets paid thirty-six dollars for three hours of work before bedtime"() {
        given:
        def hourOfPay = Babysitter.startJob(5, 8, 9)

        expect:
        hourOfPay == 36
    }

    def "babysitter gets paid eight dollars after bedtime before midnight"() {
        given:
        def hourOfPay = Babysitter.startJob(10, 11, 9)

        expect:
        hourOfPay == 8
    }
}