package commands
import Canvas
import IO.OutputHandler
import visitors.ListRenderVisitor

class ListRender(val canvas: Canvas): Command{

    override fun execute() {
        OutputHandler.printCanvas(canvas, ListRenderVisitor())
    }
}