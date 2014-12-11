class Babysitter {

    private static final def MIDNIGHT = 12

    static def calculatePay(startTime, endTime, bedTime) {
        def payment = 0

        // Calculate each hour independently
        for (def currentTime = startTime; currentTime < endTime; currentTime ++) {
            if (currentTime < bedTime) {
                payment += 12
            } else if (currentTime < MIDNIGHT) {
                payment += 8
            } else {
                payment += 16
            }
        }
        payment
    }
}