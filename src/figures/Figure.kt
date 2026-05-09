package figures
import Coordinate
import visitors.CanvasVisitor
import Cell

abstract class Figure(val origin: Coordinate) {

    abstract fun accept(visitor: CanvasVisitor, cell: Cell)
}