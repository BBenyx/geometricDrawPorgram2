package commands
import Canvas
import RenderContext
import factory.CellFactory
import factory.TriangleFactory

class AddNewTriangle(private val canvas: Canvas): Command {

    override fun execute() {
        val figure = TriangleFactory.create()
        val cell = CellFactory.create()

        canvas.addElement(RenderContext(figure, cell))
    }
}