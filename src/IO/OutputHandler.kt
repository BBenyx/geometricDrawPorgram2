package IO

import visitors.CanvasVisitor

class  OutputHandler(private var renderType: CanvasVisitor) {

    fun setRenderType(renderType: CanvasVisitor) {
        this.renderType = renderType
    }

    /*TODO*/



    fun <T> applyColor(element: T, color: Color): String {
        return when (color) {
            Color.RED -> element.toString().red()
            Color.GREEN -> element.toString().green()
            Color.YELLOW -> element.toString().yellow()
            Color.BLUE -> element.toString().blue()
            Color.WHITE -> element.toString().white()
            Color.DEFAULT -> element.toString()
        }
    }

    fun String.red() = "\u001B[31m$this\u001B[0m"
    fun String.green() = "\u001B[32m$this\u001B[0m"
    fun String.yellow() = "\u001B[33m$this\u001B[0m"
    fun String.blue() = "\u001B[34m$this\u001B[0m"
    fun String.white() = "\u001B[37m$this\u001B[0m"
}