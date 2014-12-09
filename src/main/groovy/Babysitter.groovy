class Babysitter {

    static def startJob(startTime, endTime, bedTime) {
        endTime > bedTime ? 8 : (endTime - startTime) * 12
    }
}