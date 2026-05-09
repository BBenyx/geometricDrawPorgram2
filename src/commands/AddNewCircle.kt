package commands
import Canvas
import factory.CellFactory
import factory.CircleFactory
import RenderContext

class AddNewCircle(private val canvas: Canvas): Command{

    override fun execute() {
        val figure = CircleFactory.create()
        val cell = CellFactory.create()

        canvas.addElement(RenderContext(figure, cell))
    }
}