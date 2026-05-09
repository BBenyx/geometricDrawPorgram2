package figures
import Cell
import Coordinate
import visitors.CanvasVisitor

class Circle(
    val radius: UInt,
    origin: Coordinate,
    ): Figure(origin) {

    override fun accept(visitor: CanvasVisitor, cell: Cell) {
        visitor.visit(this, cell)
    }
}