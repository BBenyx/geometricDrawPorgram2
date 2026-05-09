package visitors
import Canvas
import figures.*
import RGB
import Cell

class ColorRenderVisitor(): CanvasVisitor {
    private var _grid: ArrayList<ArrayList<String>> = ArrayList()

    val grid: List<List<String>>
    get() = _grid


    override fun visit(canvas: Canvas) {

        _grid = RenderLogic.createBlankGrid(canvas.width.toInt(), canvas.height.toInt())
    }

    override fun visit(rectangle: Rectangle, cell: Cell) {
        RenderLogic.drawRectangleOnGrid(rectangle, _grid) {cell.placeHolder.color(cell.color)}
    }

    override fun visit(triangle: Triangle, cell: Cell) {
        RenderLogic.drawTriangleOnGrid(triangle, _grid) {cell.placeHolder.color(cell.color)}
    }

    override fun visit(circle: Circle, cell: Cell) {
        RenderLogic.drawCircleOnGrid(circle, _grid) {cell.placeHolder.color(cell.color)}
    }


    private fun String.color(rgb: RGB) = "\u001B[38;2;${rgb.r};${rgb.g};${rgb.b}m$this\u001B[0m"

}