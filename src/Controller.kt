import IO.InputHandler
import IO.OutputHandler
import commands.AddNewRectangle
import IO.Color
import commands.AddNewCircle
import commands.AddNewTriangle
import visitors.*
import java.awt.Menu

class Controller private constructor(
    val inputHandler: InputHandler,
    val outputHandler: OutputHandler,
    private var renderType: CanvasVisitor,
    val history: History,
    var canvas: Canvas,
) {
    constructor(): this(InputHandler(), OutputHandler(), DefaultRender(), History(), Canvas(0u,0u))

    init {
        canvas = Canvas(
            inputHandler.uIntInput("Canvas width: "),
            inputHandler.uIntInput("Canvas height: "),
        )
    }

    fun sendOutput() {
        when (renderType) {
            is DefaultRender -> outputHandler.printCanvas(canvas, DefaultRender())
            is ColorRender -> outputHandler.printCanvas(canvas, ColorRender())
            is ListRender -> outputHandler.printCanvas(canvas, ListRender())
            else -> outputHandler.printCanvas(canvas, ColorRender())
        }
    }

    fun setRenderType(renderType: CanvasVisitor) {
        this.renderType = renderType
        outputHandler.printMessage("\n Setting up rendering type... \n")
        sendOutput()

        handleMenu()
    }

    fun addRectangle() {
        history.add(AddNewRectangle(
            canvas,
            heightWidth = Pair(
                inputHandler.uIntInput("\nRectangle width: "),
                inputHandler.uIntInput("Rectangle height: ")
            ),
            placeholder = inputHandler.stringInput("Placeholder character: "),
            origin = inputHandler.coordinateInput("The input of the origin: "),
            color = getColor(),
        ))

        history.peak()!!.execute()
        sendOutput()

        handleMenu()
    }

    fun addTriangle() {
        history.add(AddNewTriangle(
            canvas,
            listOf(
                inputHandler.coordinateInput("\nPoint1 of the triangle: "),
                inputHandler.coordinateInput("\nPoint2 of the triangle: "),
                inputHandler.coordinateInput("\nPoint3 of the triangle: "),
            ),
            placeholder = inputHandler.stringInput("Placeholder character: "),
            color = getColor(),
        ))

        history.peak()!!.execute()
        sendOutput()

        handleMenu()
    }

    fun addCircle() {
        history.add(AddNewCircle(
            canvas,
            inputHandler.uIntInput("\nHeight of the circle: "),
            inputHandler.stringInput("Placeholder character: "),
            inputHandler.coordinateInput("The center of the circle: "),
            color = getColor(),
        ))

        history.peak()!!.execute()
        sendOutput()

        handleMenu()
    }

    val commandList: List<MenuItem> = listOf(
        MenuItem("\n0. Set render to default") { setRenderType(DefaultRender()) },
        MenuItem("1. Set render to color") { setRenderType(ColorRender()) },
        MenuItem("2. Set render to list") { setRenderType(ListRender()) },
        MenuItem("3. Add new rectangle") { addRectangle() },
        MenuItem("4. Add new triangle") { addTriangle() },
        MenuItem("5. Add new circle") { addCircle() },
    )

    fun handleMenu() {

        for (elem in commandList) {
            println(elem.label)
        }
        val input = inputHandler.intInput("Enter command number: ")
        try {
            commandList[input].action()
        } catch (e: IndexOutOfBoundsException) {
            handleMenu()
        }
    }

    fun getColor(): Color {
        val message = """
            |Please choose a color by typing its number
            |0. Default, 1. Red, 2. Green, 3. Yellow, 4. Blue, 5. White
        """.trimMargin()

        return when (inputHandler.intInput(message)) {
            0 -> Color.DEFAULT
            1 -> Color.RED
            2 -> Color.GREEN
            3 -> Color.YELLOW
            4 -> Color.BLUE
            5 -> Color.WHITE
            else -> Color.DEFAULT
        }
    }
}