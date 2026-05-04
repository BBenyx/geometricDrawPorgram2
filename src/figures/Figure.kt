package figures
import Coordinate
import IO.Color
import visitors.CanvasVisitor

abstract class Figure(
    val origin: Coordinate,
    val color: Color,
    val placeHolder: String,) {

    abstract fun accept(visitor: CanvasVisitor)
}