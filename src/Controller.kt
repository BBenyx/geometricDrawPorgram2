import IO.InputHandler

class Controller private constructor(
    var canvas: Canvas,
) {
    constructor(): this(Canvas(0u,0u))

    init {
        canvas = Canvas(
            InputHandler.uIntInput("Canvas width: "),
            InputHandler.uIntInput("Canvas height: "),
        )
    }

    val commandList: List<MenuItem> = listOf(
        MenuItem("\n0. Render") { commands.DefaultRender(canvas).execute() },
        MenuItem("1. Render in color") { commands.ColorRenderVisitor(canvas).execute() },
        MenuItem("2. Render in list") { commands.ListRender(canvas).execute() },
        MenuItem("3. Add new rectangle") { commands.AddNewRectangle(canvas).execute() },
        MenuItem("4. Add new triangle") { commands.AddNewTriangle(canvas).execute() },
        MenuItem("5. Add new circle") { commands.AddNewCircle(canvas).execute() },
    )

    fun handleMenu() {

        for (elem in commandList) {
            println(elem.label)
        }
        val input = InputHandler.intInput("Enter command number: ")
        try {
            commandList[input].action()
            handleMenu()
        } catch (e: IndexOutOfBoundsException) {
            handleMenu()
        }
    }

}