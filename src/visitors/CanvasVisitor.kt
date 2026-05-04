package visitors
import Canvas
import figures.*
import figures.Rectangle

interface CanvasVisitor {
    fun visit(canvas: Canvas)
    fun visit(rectangle: Rectangle)
    fun visit(triangle: Triangle)
    fun visit(circle: Circle)
}