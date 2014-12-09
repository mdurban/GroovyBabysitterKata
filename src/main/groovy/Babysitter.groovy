class Babysitter {

    private def startTime
    private def endTime

    static def calculatePay(startTime, endTime, bedTime) {
        def hoursWorked = endTime - startTime
        endTime > bedTime ? hoursWorked * 8 : hoursWorked * 12
    }
}