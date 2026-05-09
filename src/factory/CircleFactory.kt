package factory
import IO.InputHandler
import figures.Circle

object CircleFactory: Factory<Circle> {

    override fun create(): Circle {
        val radius = InputHandler.uIntInput("Enter radius: ")
        val origin = InputHandler.coordinateInput("Enter the origin coordinate (eg: 1,2): ")

        return Circle(radius, origin)
    }
}