import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextArea
import javax.swing.JTextField
import kotlin.system.exitProcess

class test(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 300)
        setLocationRelativeTo(null)

        val hello = JTextArea("Hello", 1, 11)
        hello.setBounds(16,16,200,200)
        //val pane = contentPane
        //pane.layout = null

        val goodbye = JButton("Good Bye")
        goodbye.addActionListener {
            exitProcess(0)
        }

        layout = GridLayout(1,2)

        add(hello)
        add(goodbye)

        isVisible = true
    }
}