package figures
import Coordinate
import IO.Color
import visitors.CanvasVisitor

class Rectangle private constructor(
    val height: UInt,
    val width: UInt,
    origin: Coordinate,
    placeholder: Char,
    color: Color,
    ): Figure(origin, color, placeholder) {

    override fun accept(visitor: CanvasVisitor) {
        visitor.visit(this)
    }

    companion object {
        fun fromSize(
            heightWidth: Pair<UInt,UInt>,
            placeholder: Char,
            origin: Coordinate = Coordinate(0,0),
            color: Color = Color.DEFAULT): Rectangle {

            return Rectangle(
                heightWidth.first,
                heightWidth.second,
                origin,
                placeholder,
                color,
            )
        }
    }
}