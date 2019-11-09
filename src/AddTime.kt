import kotlin.math.floor
import kotlin.math.roundToInt

object AddTime {

    var hours = 0
    var h0 = 0
    var h1 = 0
    var m0 = 0
    var m1 = 0
    var s0 = 0
    var s1 = 0
    var minutes = 0
    var seconds = 0
    var temp0 = "default"
    var temp1 = "default"
    var mathIn = "default"
    var operatorIndex = 0
    var isAdded = true
    var answer = "Hello"
    var operator = "+"
    var count0 = 0
    var count1 = 0
    var containsSpace = false

    fun parseOp(MathIn: String){

        mathIn = MathIn
        isAdded = mathIn.contains("+")
        operatorIndex = mathIn.indexOf(" ")
        temp0 = mathIn.subSequence(0, operatorIndex).toString()
        operatorIndex = mathIn.lastIndexOf(" ")
        operatorIndex++
        temp1 = mathIn.subSequence(operatorIndex, mathIn.length).toString()
        h0 = temp0.subSequence(0, temp0.indexOf(":")).toString().toInt()
        temp0 = temp0.subSequence((temp0.indexOf(":"))+1, temp0.length).toString()
        m0 = temp0.subSequence(0, temp0.indexOf(":")).toString().toInt()
        temp0 = temp0.subSequence((temp0.indexOf(":"))+1, temp0.length).toString()
        s0 = temp0.toInt()
        m0 += (h0 * 60)
        s0 += (m0 * 60)

        h1 = temp1.subSequence(0, temp1.indexOf(":")).toString().toInt()
        temp1 = temp1.subSequence((temp1.indexOf(":"))+1, temp1.length).toString()
        m1 = temp1.subSequence(0, temp1.indexOf(":")).toString().toInt()
        temp1 = temp1.subSequence((temp1.indexOf(":"))+1, temp1.length).toString()
        s1 = temp1.toInt()
        m1 += (h1 * 60)
        s1 += (m1 * 60)
    }
    fun addingTime1() {
        println("isAdded: $isAdded")
        println("count0: $count0")
        seconds = if (isAdded){
            s0 + s1
        } else{
            s0 - s1
        }
        println("Answer in seconds: $seconds")
        minutes = floor(seconds.toDouble() / 60.0).toInt()
        seconds %= 60
        hours = floor(minutes.toDouble() / 60.0).toInt()
        minutes %= 60

        var hStr = ""
        var mStr = ""
        var sStr = ""

        hStr = if(hours < 10){
            "0".plus(hours.toString())
        }else{
            hours.toString()
        }
        mStr = if(minutes < 10){
            "0".plus(minutes.toString())
        }else{
            minutes.toString()
        }
        sStr = if(seconds < 10){
            "0".plus(seconds.toString())
        }else{
            seconds.toString().toString()
        }

        answer = hStr.plus(":").plus(mStr).plus(":").plus(sStr)
    }
    fun parseOp2(MathIn: String){
        println("called parseOp")
        println("Seconds was $seconds")
        println("Minutes was $minutes")
        println("Hours was $hours")
        h0 = 0
        h1 = 0
        m0 = 0
        m1 = 0
        s0 = 0
        s1 = 0
        count0 = 0
        count1 = 0
        var temp = MathIn.replace(" ", "")
        if(temp.contains("+")||temp.contains("-")){
            operator = if (temp.contains("+")){
                "+"
            }else{
                "-"
            }
            isAdded = operator == "+"
            temp0 = temp.substringBefore(operator)
            count0 = temp0.length
            for (char in temp0){
                if (char.equals(':')){
                    count0--
                }
            }
            temp1 = temp.substringAfter(operator)
            count1 = temp1.length
            for (char in temp1){
                if (char.equals(':')){
                    count1--
                }
            }
            when (count0){
                0 -> {
                    h0 = hours
                    m0 = minutes
                    s0 = seconds
                    println("Prior answer in seconds")
                }
                1 , 2 -> {
                        s0 = temp.substringBefore(operator).toInt()
                        println(temp.substringBefore(operator))
                        }
                3 , 4 -> {
                    m0 = temp.substringBefore(":").toInt()
                    temp0 = temp.substringAfter(":")
                    s0 = temp0.substringBefore(operator).toInt()
                }
                5 , 6 -> {
                    h0 = temp.substringBefore(":").toInt()
                    m0 = temp.substringAfter(":").substringBefore(operator).substringBefore(":").toInt()
                    s0 = temp.substringAfter(":").substringAfter(":").substringBefore(operator).toInt()
                }
            }
            when (count1){
                0 -> answer = "Invalid Operation"
                1 , 2 -> s1 = temp.substringAfter(operator).toInt()
                3 , 4 -> {
                    s1 = temp.substringAfterLast(":").toInt()
                    m1 = temp.substringAfter(operator).substringBefore(":").toInt()
                }
                5 , 6 -> {
                    s1 = temp.substringAfterLast(":").toInt()
                    m1 = temp.substringAfter(operator).substringAfter(":").substringBeforeLast(":").toInt()
                    h1 = temp.substringAfter(operator).substringBefore(":").toInt()
                }
            }
        }else{
            answer = "Invalid Operation"
        }
        println("${h0.toString().plus(":").plus(m0.toString()).plus(":").plus(s0.toString())} $operator ${h1.toString().plus(":").plus(m1.toString()).plus(":").plus(s1.toString())}")
        m0 += h0 * 60
        s0 += m0 * 60
        m1 += h1 * 60
        s1 += m1 * 60
        println("$s0 $operator $s1")
    }
}