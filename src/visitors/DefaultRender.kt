package visitors
import Canvas
import figures.*

class DefaultRender(): CanvasVisitor {
    private var _grid: ArrayList<ArrayList<String>> = ArrayList()

    val grid: List<List<String>>
    get() = _grid


    override fun visit(canvas: Canvas) {

        _grid = RenderLogic.createBlankGrid(canvas.width.toInt(), canvas.height.toInt())
    }

    override fun visit(rectangle: Rectangle) {
        RenderLogic.drawRectangleOnGrid(rectangle, _grid) {it.placeHolder}
    }

    override fun visit(triangle: Triangle) {
        RenderLogic.drawTriangleOnGrid(triangle, _grid) {it.placeHolder}
    }

    override fun visit(circle: Circle) {
        RenderLogic.drawCircleOnGrid(circle, _grid) {it.placeHolder}
    }


}