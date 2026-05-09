package figures
import Cell
import Coordinate
import visitors.CanvasVisitor

class Rectangle(
    val height: UInt,
    val width: UInt,
    origin: Coordinate,
    ): Figure(origin) {

    override fun accept(visitor: CanvasVisitor, cell: Cell) {
        visitor.visit(this, cell)
    }
}