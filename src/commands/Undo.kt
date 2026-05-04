package commands
import Canvas
import figures.Figure

class Undo(val canvas: Canvas, val element: Figure): Command {
    override fun execute() {
        canvas.removeElement(element)
    }
}