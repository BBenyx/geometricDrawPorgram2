package IO
import Canvas
import visitors.*

object OutputHandler {

    fun printCanvas(canvas: Canvas, type: DefaultRenderVisitor) {
        canvas.accept(type)
        val grid = type.grid
        print2DList(grid)
    }

    fun printCanvas(canvas: Canvas, type: ColorRenderVisitor) {
        canvas.accept(type)
        val grid = type.grid
        print2DList(grid)
    }

    fun printCanvas(canvas: Canvas, type: ListRenderVisitor) {
        canvas.accept(type)
        val instanceList = type.instanceInfo

        printList(instanceList)
    }

    fun printMessage(message: String) {
        println(message)
    }

    fun <T> printList(list: List<T>) {
        for (elem in list) {
            println(elem)
        }
    }

    fun <T> print2DList(list: List<List<T>>) {
        for (row in list) {
            for (elem in row) {
                print(elem)
            }
            println()
        }
    }
}