package figures
import Coordinate
import visitors.CanvasVisitor
import Cell

class Triangle(
    val p1: Coordinate,
    val p2: Coordinate,
    val p3: Coordinate,
    ): Figure(
    minOf(p1,p2,p3)) {

    override fun accept(visitor: CanvasVisitor, cell: Cell) {
        visitor.visit(this, cell)
    }

}