import spock.lang.Specification

class BabysitterTest extends Specification {

    def "babysitter can start a job"() {
        given:
            def jobStarted = Babysitter.startJob(5, 10, 9)

        expect:
            jobStarted
    }
}
