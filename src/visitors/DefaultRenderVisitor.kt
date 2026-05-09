package visitors
import Canvas
import figures.*
import Cell

class DefaultRenderVisitor(): CanvasVisitor {
    private var _grid: ArrayList<ArrayList<String>> = ArrayList()
    val grid: List<List<String>>
    get() = _grid

    override fun visit(canvas: Canvas) {
        _grid = RenderLogic.createBlankGrid(canvas.width.toInt(), canvas.height.toInt())
    }

    override fun visit(rectangle: Rectangle, cell: Cell) {
        RenderLogic.drawRectangleOnGrid(rectangle, _grid) {cell.placeHolder}
    }

    override fun visit(triangle: Triangle, cell: Cell) {
        RenderLogic.drawTriangleOnGrid(triangle, _grid) {cell.placeHolder}
    }

    override fun visit(circle: Circle, cell: Cell) {
        RenderLogic.drawCircleOnGrid(circle, _grid) {cell.placeHolder}
    }


}