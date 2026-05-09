package IO
import Canvas
import visitors.*

object OutputHandler {

    fun printCanvas(canvas: Canvas, type: DefaultRenderVisitor) {
        canvas.accept(type)
        val grid = type.grid
        print2DGrid(grid)
    }

    fun printCanvas(canvas: Canvas, type: ColorRenderVisitor) {
        canvas.accept(type)
        val grid = type.grid
        print2DGrid(grid)
    }

    fun printCanvas(canvas: Canvas, type: ListRenderVisitor) {
        canvas.accept(type)
        val instanceList = type.instanceInfo

        for (instance in instanceList) {
            println(instance)
        }
    }

    fun printMessage(message: String) {
        println(message)
    }

    private fun print2DGrid(grid: List<List<String>>) {
        for (row in grid) {
            for (elem in row) {
                print(elem)
            }
            println()
        }
    }
}