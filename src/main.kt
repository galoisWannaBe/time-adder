import java.awt.EventQueue
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextArea
import javax.swing.JTextField

class mainUI(title: String) : JFrame(){

    init{createUI(title)}



    private fun createUI(title: String) {
        setTitle(title)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(1024, 720)
        setLocationRelativeTo(null)

        val pane = contentPane
        pane.layout = null

        val btnCalc = JButton("Calculate")
        val btnGoToSlip = JButton("Slip?")
        val calculation = JTextField(25)
        val answer = JTextField(10)
        btnCalc.addActionListener {
            val timeMath = AddTime()
            var adding = calculation.text
            timeMath.parseOp(adding)
            timeMath.addingTime1()
            answer.text = timeMath.answer }
        calculation.addActionListener {
            val timeMath = AddTime()
            var adding = calculation.text
            timeMath.parseOp(adding)
            timeMath.addingTime1()
            answer.text = timeMath.answer
        }
        btnGoToSlip.addActionListener {
            EventQueue.invokeLater(::openSlips)
        }

        calculation.setBounds(16,16,200,40)
        btnCalc.setBounds(232,16,80,40)
        answer.setBounds(16, 70, 80, 40)
        btnGoToSlip.setBounds(232, 72, 80, 42)

        pane.add(btnCalc)
        pane.add(btnGoToSlip)
        pane.add(calculation)
        pane.add(answer)
    }
}
private fun openSlips(){

    val slips = slippageFinderUI("Slippage")
    slips.isVisible = true

    //val testing = test("Hi?")
}

private fun createAndShowGUI(){
    val frame = mainUI("Adding Time")
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}
