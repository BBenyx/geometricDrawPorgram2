package IO

import Canvas
import visitors.*

class  OutputHandler {

    fun printCanvas(canvas: Canvas, type: DefaultRender) {
        canvas.accept(type)
        val grid = type.grid
        print2DGrid(grid)
    }

    fun printCanvas(canvas: Canvas, type: ColorRender) {
        canvas.accept(type)
        val grid = type.grid
        print2DGrid(grid)
    }

    fun printCanvas(canvas: Canvas, type: ListRender) {
        canvas.accept(type)
        val grid = type.grid

        for (subGrind in grid) {
            print2DGrid(subGrind)
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