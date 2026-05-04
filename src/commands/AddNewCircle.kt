package commands
import Canvas
import Coordinate
import IO.Color
import figures.Circle

class AddNewCircle(
    val canvas: Canvas,
    val height: UInt,
    val placeholder: Char,
    val origin: Coordinate = Coordinate(0, 0),
    val color: Color = Color.DEFAULT,): Command {

    override fun execute() {
        canvas.addElement(Circle.fromHeight(height, placeholder, origin, color))
    }
}