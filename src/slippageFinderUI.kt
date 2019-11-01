import java.awt.BorderLayout
import java.awt.BorderLayout.CENTER
import java.awt.Component
import java.awt.EventQueue
import java.awt.GridLayout
import java.util.*
import javax.swing.*
import kotlin.collections.ArrayList

class slippageFinderUI(title: String) : JFrame() {

    val slips = slippageFinder()
    val startText = JTextField()
    val endText = JTextField()
    val checkBreak1 = JCheckBox()
    val checkLunch = JCheckBox()
    val checkBreak2 = JCheckBox()
    val labelNew = JTextField()
    val timeNew = JTextField()
    val durationNew = JTextField()
    val eventsTable = JTable()

    val rightPanel = JPanel()
    val leftPanel = JPanel()

    val leftTop = JPanel()
    val leftJustLeft = JPanel()
    val leftBottom = JPanel()

    init{createUI(title)
        isVisible = true}

    private fun createUI(title: String) {
        setTitle(title)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(1024, 720)
        setLocationRelativeTo(null)
        isVisible = true

        createLayout()

    }
    private fun createLayout(){
        layout = GridLayout(1,2)
        createTable()
        createBigLeft()
        add(leftPanel)
        add(rightPanel)
    }
    private fun createTable(){
        //right side of layout
        rightPanel.layout = BorderLayout()
        rightPanel.add(eventsTable, CENTER)
    }
    private fun createBigLeft(){
        //left side of layout
        leftPanel.layout = GridLayout(3,1)
        createSetTOD()
        createSelectExisting()
        createNewEvents()
        leftPanel.add(leftTop)
        leftPanel.add(leftJustLeft)
        leftPanel.add(leftBottom)
    }
    private fun createSetTOD(){
        //top left; choose/enter start and end time
        leftTop.add(startText)
        leftTop.add(endText)
    }
    private fun createSelectExisting(){
        //checkboxes for both breaks and lunches
        leftJustLeft.add(checkBreak1)
        leftJustLeft.add(checkLunch)
        leftJustLeft.add(checkBreak2)
    }
    private fun createNewEvents(){
        //bottom left; Enter new events
        leftBottom.add(labelNew)
        leftBottom.add(timeNew)
        leftBottom.add(durationNew)
    }
}