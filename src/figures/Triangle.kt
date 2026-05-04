package figures
import Coordinate
import IO.Color
import visitors.CanvasVisitor

class Triangle private constructor(
    val p1: Coordinate,
    val p2: Coordinate,
    val p3: Coordinate,
    placeholder: String,
    color: Color,
    ): Figure(
    Coordinate(
        minOf(p1.x, p2.x, p3.x),
        minOf(p1.y, p2.y, p3.y)),
    color,
    placeholder) {

    override fun accept(visitor: CanvasVisitor) {
        visitor.visit(this)
    }

    companion object {
        fun fromPoints(
            points: List<Coordinate>,
            placeholder: String,
            color: Color = Color.DEFAULT): Triangle {

            require(points.size == 3) {"Triangle can only be created with 3 points!"}

            return Triangle(
                points[0],
                points[1],
                points[2],
                placeholder,
                color,
            )
        }
    }
}