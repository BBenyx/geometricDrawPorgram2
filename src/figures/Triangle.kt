package figures
import Coordinate
import IO.Color
import visitors.CanvasVisitor

class Triangle private constructor(
    val p1: Coordinate,
    val p2: Coordinate,
    val p3: Coordinate,
    placeholder: Char,
    color: Color,
    ): Figure(Coordinate(0,0) /*TODO real origin will be needed*/, color, placeholder) {

    override fun accept(visitor: CanvasVisitor) {
        visitor.visit(this)
    }

    companion object {
        fun fromPoints(
            points: List<Coordinate>,
            placeholder: Char,
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