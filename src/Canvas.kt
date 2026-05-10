import visitors.CanvasVisitor

class Canvas(
    val width: UInt,
    val height: UInt,
    private val _elements: ArrayList<RenderContext> = arrayListOf(),
) {
    val elements: List<RenderContext>
    get() = _elements

    fun accept(visitor: CanvasVisitor) {
        visitor.visit(this)
        for (elem in elements) {
            elem.figure.accept(visitor, elem.cell)
        }
    }

    fun addElement(element: RenderContext) = _elements.add(element)
}