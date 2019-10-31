import kotlin.math.atan

class slippageFinder {

    var hrs = 0
    var mins = 0
    var endTime = event("End Time", "17:30")
    var startTime = event("Start Time", "09:00")
    var break0 = event("First Break", "10:35", "00:15")
    var lunch = event("Lunch","13:10", "00:30")
    var break1 = event("second Break","15:40", "00:15")
    var Meeting = event("Meeting","15:10", "01:00")
    var ReadTime = event("Read", "15:10", "01:00")
    var listedEvents = arrayListOf(break0, lunch, break1)
    var haveRead = false
    var haveMeet = false
    var takeLunch = true
    var takeBreak = true

    fun addTime(thisTime: event){
        hrs += thisTime.hr
        mins += thisTime.hr
        if (mins >= 60){
            mins -= 60
            hrs ++
        }
    }
    fun subTime(thisTime: event){
        hrs -= thisTime.hr
        if (mins < thisTime.min){
            hrs --
            mins += 60
        }
        mins -= thisTime.min
    }
    fun addEvent(theEvent: event){
        listedEvents.add(theEvent)
        listedEvents.sortWith(compareBy ({ it.hr }, {it.min}))
    }

}