package commands
import Canvas
import Coordinate
import IO.Color
import figures.Rectangle

class AddNewRectangle(
    val canvas: Canvas,
    val heightWidth: Pair<UInt, UInt>,
    val placeholder: Char,
    val origin: Coordinate = Coordinate(0, 0),
    val color: Color = Color.DEFAULT,): Command {

    override fun execute() {
        canvas.addElement(Rectangle.fromSize(heightWidth, placeholder, origin, color))
    }
}