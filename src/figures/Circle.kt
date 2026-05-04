package figures
import Coordinate
import IO.Color
import visitors.CanvasVisitor

class Circle private constructor(
    val height: UInt,
    origin: Coordinate,
    placeholder: String,
    color: Color,
    ): Figure(origin, color, placeholder) {

    override fun accept(visitor: CanvasVisitor) {
        visitor.visit(this)
    }

    companion object {
        fun fromHeight(
            height: UInt,
            placeholder: String,
            origin: Coordinate = Coordinate(0,0),
            color: Color = Color.DEFAULT): Circle {

            return Circle(
                height,
                origin,
                placeholder,
                color,
            )
        }
    }
}