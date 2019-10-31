import java.awt.BorderLayout
import java.awt.EventQueue
import java.awt.GridLayout
import java.util.*
import javax.swing.*
import kotlin.collections.ArrayList

class slippageFinderUI(title: String) : JFrame() {

    val slips = slippageFinder()

    init{createUI(title)
        isVisible = true}

    private fun createUI(title: String) {
        setTitle(title)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(1024, 720)
        setLocationRelativeTo(null)
        isVisible = true

        val controls = JPanel()
        val eventsList = JPanel()

        controls.layout = GridLayout(2,1)

        val selectEvents = JPanel()
        //selectEvents.layout = GroupLayout()

        val addNewEvent = JPanel()
        addNewEvent.layout = GridLayout()

        val eventLabel = JTextField()
        val eventTime = JTextField()
        val eventDuration = JTextField()

        eventTime.addActionListener {
            slips.listedEvents.add(event(eventLabel.text, eventTime.text))
        }
        eventDuration.addActionListener {
            slips.listedEvents.add(event(eventLabel.text, eventTime.text, eventDuration.text))
        }

        addNewEvent.add(eventLabel)
        addNewEvent.add(eventTime)
        addNewEvent.add(eventDuration)

        eventsList.layout = BorderLayout()

        layout = GridLayout(1,2)
        add(controls)
        add(eventsList)
    }
}