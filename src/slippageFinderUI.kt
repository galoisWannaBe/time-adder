import java.awt.*
import java.awt.BorderLayout.CENTER
import java.util.*
import javax.swing.*
import kotlin.collections.ArrayList

class slippageFinderUI(Title: String) : JFrame() {

    val slips = slippageFinder()
    val startText = JTextField(" 9:00", 5)
    val endText = JTextField("17:30", 5)
    val checkBreak1 = JCheckBox("Break 1")
    val checkLunch = JCheckBox("Lunch")
    val checkBreak2 = JCheckBox("Break 2")
    val labelNew = JTextField(25)
    val timeNew = JTextField(5)
    val durationNew = JTextField(5)

    val startLabel = JLabel("Start")
    val endLabel = JLabel("End")
    val labelLabel = JLabel("Label")
    val timeLabel = JLabel("Time")
    val durationLabel = JLabel("Duration")

    val rightPanel = JPanel()
    val leftPanel = JPanel()

    val leftTop = JPanel()
    val leftJustLeft = JPanel()
    val leftBottom = JPanel()

    var arrList = ArrayList<Array<String>>()

    init{createUI(Title)
        isVisible = true}

    private fun createUI(Title: String) {
        title = Title
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
        for (obj in slips.listedEvents){
            arrList.add(arrayOf<String>(obj.Label, obj.TimeStr, obj.Duration))
        }
        var allArr = arrayOf(arrList[0])
        for (i in 1 until arrList.size){
            allArr = allArr.plus(arrList[i])
        }
        var columnNames = arrayOf<String>("Label", "Time", "Duration")
        val eventsTable = JTable(allArr, columnNames)
        val tablePane = JScrollPane()
        tablePane.add(eventsTable)
        rightPanel.layout = BorderLayout()
        rightPanel.add(tablePane, CENTER)
    }
    private fun createBigLeft(){
        //left side of layout
        leftPanel.layout = GridLayout(3,1)
        createSetTOD()
        createSelectExisting()
        createNewEvents()
        val topLeftPanelPanel = JPanel()
        leftPanel.add(leftTop)
        leftPanel.add(leftJustLeft)
        leftPanel.add(leftBottom)
    }
    private fun createSetTOD(){
        //top left; choose/enter start and end time
        leftTop.layout = GridLayout(2,1)
        val topTexts = JPanel()
        val topLabels = JPanel()
        topTexts.layout = FlowLayout()
        topLabels.layout = FlowLayout()
        topTexts.add(startText)
        topTexts.add(endText)
        leftTop.add(topTexts)
        topLabels.add(startLabel)
        topLabels.add(endLabel)
        leftTop.add(topLabels)
    }
    private fun createSelectExisting(){
        //checkboxes for both breaks and lunches
        leftJustLeft.layout = FlowLayout()
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