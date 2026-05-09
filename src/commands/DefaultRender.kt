package commands
import Canvas
import IO.OutputHandler
import visitors.DefaultRenderVisitor

class DefaultRender(val canvas: Canvas): Command{

    override fun execute() {
        OutputHandler.printCanvas(canvas, DefaultRenderVisitor())
    }
}