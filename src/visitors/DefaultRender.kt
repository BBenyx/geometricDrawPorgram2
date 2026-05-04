package visitors
import Canvas
import figures.*
import Cell
import IO.Color
import Coordinate

class DefaultRender(): CanvasVisitor {
    /*private*/ val grid: ArrayList<ArrayList<Cell>> = ArrayList()

    override fun visit(canvas: Canvas) {
        createBlankGrid(canvas.width.toInt(), canvas.height.toInt(), grid)
    }

    override fun visit(rectangle: Rectangle) {
        drawRectangleOnGrid(rectangle, grid)
    }

    override fun visit(triangle: Triangle) {
        TODO("Not yet implemented")
    }

    override fun visit(circle: Circle) {
        TODO("Not yet implemented")
    }

    private fun createBlankGrid(
        width: Int,
        height: Int,
        grid: ArrayList<ArrayList<Cell>>) {

        for (i in 0..<height) {
            val currentArray: ArrayList<Cell> = ArrayList()
            for (cell in 0..<width) {
                currentArray.add(Cell(' ', Color.DEFAULT))
            }
            grid.add(currentArray)
        }
    }

    private fun drawRectangleOnGrid(rectangle: Rectangle, grid: ArrayList<ArrayList<Cell>>) {
        if (rectangle.height == 0u || rectangle.width == 0u) { return }
        val origin = rectangle.origin

        for (line in origin.y..<origin.y + rectangle.height.toInt()) {

            for (cell in origin.x..<origin.x + rectangle.width.toInt()) {

                val cellCoordinate = Coordinate(cell, line)
                val newCell = Cell(rectangle.placeHolder, rectangle.color)
                tryToChangeCell(cellCoordinate, newCell, grid)
            }
        }
    }

    private fun tryToChangeCell(
        cellCoordinate: Coordinate,
        newCell: Cell,
        grid: ArrayList<ArrayList<Cell>>) {
        try {
            grid[cellCoordinate.y][cellCoordinate.x] = newCell
        } catch (e: Exception){
            return
        }
    }
}