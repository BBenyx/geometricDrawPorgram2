package visitors
import Canvas
import figures.*
import Cell

class ListRenderVisitor(): CanvasVisitor {

    private val _instanceInfo: ArrayList<String> = arrayListOf()
    val instanceInfo: List<String>
        get() = _instanceInfo

    override fun visit(canvas: Canvas) {}

    override fun visit(rectangle: Rectangle, cell: Cell) {
        val instanceString = """Rectangle
            |   Height: ${rectangle.height},
            |   Width: ${rectangle.width},
            |   Origin at: (${rectangle.origin.x}, ${rectangle.origin.y})""".trimMargin()
        _instanceInfo.add(instanceString)
    }

    override fun visit(triangle: Triangle, cell: Cell) {
        val instanceString = """Triangle
            |   Point 1: ${triangle.p1.x},${triangle.p1.y},
            |   Point 2: ${triangle.p2.x},${triangle.p2.y},
            |   Point 3: ${triangle.p3.x},${triangle.p3.y},
            |   Origin at: (${triangle.origin.x}, ${triangle.origin.y})""".trimMargin()
        _instanceInfo.add(instanceString)
    }

    override fun visit(circle: Circle, cell: Cell) {
        val instanceString = """Circle
            |   Radius: ${circle.radius},
            |   Origin at: (${circle.origin.x}, ${circle.origin.y})""".trimMargin()
        _instanceInfo.add(instanceString)
    }
}