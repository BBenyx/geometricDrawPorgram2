package commands
import Canvas
import RenderContext
import factory.CellFactory
import factory.RectangleFactory

class AddNewRectangle(val canvas: Canvas): Command {

    override fun execute() {
        val figure = RectangleFactory.create()
        val cell = CellFactory.create()

        canvas.addElement(RenderContext(figure, cell))
    }
}