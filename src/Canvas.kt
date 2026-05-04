import figures.Figure
import visitors.CanvasVisitor

class Canvas(
    val width: UInt,
    val height: UInt,
    private val _elements: ArrayList<Figure> = arrayListOf(),
) {
    val elements: List<Figure>
    get() = _elements

    fun accept(visitor: CanvasVisitor) {
        visitor.visit(this)
        for (elem in elements) {
            elem.accept(visitor)
        }
    }

    fun addElement(element: Figure) = _elements.add(element)

    fun removeElement(element: Figure): Figure? {
        if (_elements.remove(element)) return element
        return null
    }
}