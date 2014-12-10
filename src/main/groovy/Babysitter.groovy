class Babysitter {

    static def calculatePay(startTime, endTime, bedTime) {
        def totalHoursWorked = endTime - startTime
        def payment = 0
        if (startTime < bedTime) {
            payment += endTime < bedTime ? totalHoursWorked * 12 : (bedTime - startTime) * 12
        }
        if (bedTime < endTime) {
            payment += startTime < bedTime ? (endTime - bedTime) * 8 : totalHoursWorked * 8
        }
        payment
    }
}