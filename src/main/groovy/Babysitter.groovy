class Babysitter {

    private static final def MIDNIGHT = 12
    private static final def PRE_BEDTIME_PAY = 12
    private static final def PRE_MIDNIGHT_PAY = 8
    private static final def POST_MIDNIGHT_PAY = 16

    static def calculatePay(startTime, endTime, bedTime) {
        def payment = 0

        (startTime..<endTime).each {
            if (it < bedTime) {
                payment += PRE_BEDTIME_PAY
            } else if (it < MIDNIGHT) {
                payment += PRE_MIDNIGHT_PAY
            } else {
                payment += POST_MIDNIGHT_PAY
            }
        }
        payment
    }
}