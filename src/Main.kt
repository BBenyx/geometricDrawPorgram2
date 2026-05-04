import commands.AddNewRectangle
import figures.Rectangle
import visitors.DefaultRender


fun main() {
    val canvas = Canvas(5u, 5u)
    val visitor = DefaultRender()

    val addRect = AddNewRectangle(canvas, Pair(3u,5u), '#')
    addRect.execute()
    println(canvas.elements)

    canvas.accept(visitor)

    println(visitor.grid)
}