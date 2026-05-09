package commands
import Canvas
import RenderContext
import factory.CellFactory
import factory.TriangleFactory

class AddNewTriangle(val canvas: Canvas): Command {

    override fun execute() {
        val figure = TriangleFactory.create()
        val cell = CellFactory.create()

        canvas.addElement(RenderContext(figure, cell))
    }
}