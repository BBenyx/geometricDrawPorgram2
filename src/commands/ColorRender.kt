package commands
import Canvas
import IO.OutputHandler
import visitors.ColorRenderVisitor

class ColorRenderVisitor(private val canvas: Canvas): Command{

    override fun execute() {
        OutputHandler.printCanvas(canvas, ColorRenderVisitor())
    }
}