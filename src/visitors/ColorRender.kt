package visitors
import Canvas
import figures.*
import IO.Color

class ColorRender(): CanvasVisitor {
    private var _grid: ArrayList<ArrayList<String>> = ArrayList()

    val grid: List<List<String>>
    get() = _grid


    override fun visit(canvas: Canvas) {

        _grid = RenderLogic.createBlankGrid(canvas.width.toInt(), canvas.height.toInt())
    }

    override fun visit(rectangle: Rectangle) {
        RenderLogic.drawRectangleOnGrid(rectangle, _grid) {applyColor(it)}
    }

    override fun visit(triangle: Triangle) {
        RenderLogic.drawTriangleOnGrid(triangle, _grid) {applyColor(it)}
    }

    override fun visit(circle: Circle) {
        RenderLogic.drawCircleOnGrid(circle, _grid) {applyColor(it)}
    }


    private fun applyColor(figure: Figure): String {
        return when (figure.color) {
            Color.RED -> figure.placeHolder.red()
            Color.GREEN -> figure.placeHolder.green()
            Color.YELLOW -> figure.placeHolder.yellow()
            Color.BLUE -> figure.placeHolder.blue()
            Color.WHITE -> figure.placeHolder.white()
            Color.DEFAULT -> figure.placeHolder
        }
    }

    private fun String.red() = "\u001B[31m$this\u001B[0m"
    private fun String.green() = "\u001B[32m$this\u001B[0m"
    private fun String.yellow() = "\u001B[33m$this\u001B[0m"
    private fun String.blue() = "\u001B[34m$this\u001B[0m"
    private fun String.white() = "\u001B[37m$this\u001B[0m"
}