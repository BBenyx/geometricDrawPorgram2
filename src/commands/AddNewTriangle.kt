package commands
import Canvas
import Coordinate
import IO.Color
import figures.Triangle

class AddNewTriangle(
    val canvas: Canvas,
    val points: List<Coordinate>,
    val placeholder: String,
    val color: Color = Color.DEFAULT,): Command {

    override fun execute() {
        canvas.addElement(Triangle.fromPoints(points, placeholder, color))
    }
}