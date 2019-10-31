class AddTime {

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

        h1 = temp1.subSequence(0, temp1.indexOf(":")).toString().toInt()
        temp1 = temp1.subSequence((temp1.indexOf(":"))+1, temp1.length).toString()
        m1 = temp1.subSequence(0, temp1.indexOf(":")).toString().toInt()
        temp1 = temp1.subSequence((temp1.indexOf(":"))+1, temp1.length).toString()
        s1 = temp1.toInt()
    }
    fun addingTime1() {

        if(isAdded){
            if(temp1.equals("default")){
                hours += h0
                minutes += m0
                seconds += s0

                }
            else {
                hours = h0 + h1
                minutes = m0 + m1
                seconds = s0 + s1
            }
            if (seconds >=60){
                seconds -= 60
                minutes ++
            }
            if (minutes >= 60){
                minutes -= 60
                hours ++
            }
        }
        if(!isAdded){
            if(s0 >= seconds){
                seconds += 60
                minutes --
            }
            if(m0 >= minutes){
                minutes += 60
                hours --
            }
            if (temp1.equals("default")){
                hours -= h0
                minutes -= m0
                seconds -= s0
            }
            else {
                hours = h0 - h1
                if(s1 > s0){
                    m0 --
                    s0 += 60
                }
                if(m1 > m0){
                    hours --
                    m0 += 60
                }
                seconds = s0 - s1
                minutes = m0 - m1
            }
        }
        answer = hours.toString().plus(":").plus(minutes.toString()).plus(":").plus(seconds.toString())
    }
}