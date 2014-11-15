import spock.lang.Specification

class PlaceholderSpec extends Specification {

    def "checks for truthiness"() {
        given:
            def placeholder = new Placeholder()

        expect:
            placeholder.isTruthy() == true
    }
}
