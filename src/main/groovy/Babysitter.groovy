class Babysitter {

    static def calculatePay(startTime, endTime, bedTime) {
        def hoursWorked = endTime - startTime
        if (startTime >= 12) {
            hoursWorked * 16
        } else {
            endTime > bedTime ? hoursWorked * 8 : hoursWorked * 12
        }
    }
}