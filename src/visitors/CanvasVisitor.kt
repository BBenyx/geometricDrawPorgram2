package visitors
import Canvas
import Cell
import figures.*
import figures.Rectangle

interface CanvasVisitor {
    fun visit(canvas: Canvas)
    fun visit(rectangle: Rectangle, cell: Cell)
    fun visit(triangle: Triangle, cell: Cell)
    fun visit(circle: Circle, cell: Cell)
}
