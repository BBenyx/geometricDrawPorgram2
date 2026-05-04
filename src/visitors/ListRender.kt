package visitors
import Canvas
import figures.*

class ListRender(): CanvasVisitor {
    private var _grid: ArrayList<ArrayList<ArrayList<String>>> = ArrayList()

    val grid: List<List<List<String>>>
    get() = _grid

    private var canvasElemCounter = 0

    override fun visit(canvas: Canvas) {
        canvasElemCounter = 0
        for (i in 0..<canvas.elements.size) {
            _grid.add(
                RenderLogic.createBlankGrid(
                    canvas.width.toInt(),
                    canvas.height.toInt()))
        }
    }

    override fun visit(rectangle: Rectangle) {
        RenderLogic.drawRectangleOnGrid(rectangle, _grid[canvasElemCounter]) {it.placeHolder}
        canvasElemCounter++

    }

    override fun visit(triangle: Triangle) {
        RenderLogic.drawTriangleOnGrid(triangle, _grid[canvasElemCounter]) {it.placeHolder}
        canvasElemCounter++
    }

    override fun visit(circle: Circle) {
        RenderLogic.drawCircleOnGrid(circle, _grid[canvasElemCounter]) {it.placeHolder}
        canvasElemCounter++
    }
}