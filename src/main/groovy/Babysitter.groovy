class Babysitter {

    static def startJob(startTime, endTime, bedTime) {
        if (endTime > bedTime) {
            8
        } else {
            (endTime - startTime) * 12
        }

    }
}