package visitors
import Canvas
import IO.Color
import figures.*
import figures.Rectangle

interface CanvasVisitor {
    fun visit(canvas: Canvas)
    fun visit(rectangle: Rectangle)
    fun visit(triangle: Triangle)
    fun visit(circle: Circle)
}
