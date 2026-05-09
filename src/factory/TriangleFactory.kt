package factory
import IO.InputHandler
import figures.Triangle

object TriangleFactory: Factory<Triangle> {

    override fun create(): Triangle {
        val p1 = InputHandler.coordinateInput("Enter the coordinate of point 1 (eg: 1,2): ")
        val p2 = InputHandler.coordinateInput("Enter the coordinate of point 2 (eg: 1,2): ")
        val p3 = InputHandler.coordinateInput("Enter the coordinate of point 3 (eg: 1,2): ")

        return Triangle(p1, p2, p3)
    }
}