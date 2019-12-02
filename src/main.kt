import java.awt.EventQueue
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextField

class mainUI(title: String) : JFrame(){

    init{createUI(title)}



    private fun createUI(Title: String) {
        title = Title
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(1024, 720)
        setLocationRelativeTo(null)

        val pane = contentPane
        pane.layout = null

        val btnCalc = JButton("Calculate")
        val calculation = JTextField(25)
        val answer = JTextField(10)
        btnCalc.addActionListener {
            var adding = calculation.text.toString()
            AddTime.parseOp2(adding)
            AddTime.addingTime1()
            answer.text = AddTime.answer
        }
        calculation.addActionListener {
            var adding = calculation.text.toString()
            AddTime.parseOp2(adding)
            AddTime.addingTime1()
            answer.text = AddTime.answer
        }
        calculation.setBounds(16,16,200,40)
        btnCalc.setBounds(232,16,80,40)
        answer.setBounds(16, 70, 80, 40)

        pane.add(btnCalc)
        pane.add(calculation)
        pane.add(answer)
    }
}

private fun createAndShowGUI(){
    val frame = mainUI("Adding Time")
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}
