class event(mLabel: String, mTimeStr: String, mDuration: String = "00:00") {

    var TimeStr = mTimeStr
    var Duration = mDuration
    var Label = mLabel
    var hr = TimeStr.subSequence(0,2).toString().toInt()
    var min = TimeStr.subSequence(3,5).toString().toInt()
    var durationH = Duration.subSequence(0,2).toString().toInt()
    var durationM = Duration.subSequence(3,5).toString().toInt()
    var startTimeDouble = hr + (min/60)
}