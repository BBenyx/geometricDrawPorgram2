package factory
import IO.InputHandler
import figures.Rectangle

object RectangleFactory: Factory<figures.Rectangle> {

    override fun create(): Rectangle {
        val height = InputHandler.uIntInput("Enter height: ")
        val width = InputHandler.uIntInput("Enter width: ")
        val origin = InputHandler.coordinateInput("Enter the origin coordinate (eg: 1,2): ")

        return Rectangle(width, height, origin)
    }
}