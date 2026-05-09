package visitors

import Coordinate
import RenderContext
import figures.Circle
import figures.Figure
import figures.Rectangle
import figures.Triangle

object RenderLogic {
        fun createBlankGrid(
            width: Int,
            height: Int,): ArrayList<ArrayList<String>>{

            val grid: ArrayList<ArrayList<String>> = ArrayList()
            for (i in 0..<height) {
                val currentArray: ArrayList<String> = ArrayList()
                for (cell in 0..<width) {
                    currentArray.add(" ")
                }
                grid.add(currentArray)
            }
            return grid
        }

        fun drawRectangleOnGrid(
            rectangle: Rectangle,
            grid: ArrayList<ArrayList<String>>,
            placeholderGetter: () -> String) {

            if (rectangle.height == 0u || rectangle.width == 0u) { return }
            val origin = rectangle.origin

            for (y in origin.y..<origin.y + rectangle.height.toInt()) {
                for (x in origin.x..<origin.x + rectangle.width.toInt()) {

                    val reverseCoordinate = Coordinate(y, x)
                    val newElement = placeholderGetter()
                    tryToChangeElement(reverseCoordinate, newElement, grid)
                }
            }
        }

        fun drawTriangleOnGrid(
            triangle: Triangle,
            grid: ArrayList<ArrayList<String>>,
            placeholderGetter: () -> String) {
            // Because of the 2D coordinates must be flipped
            val p1 = Coordinate(triangle.p1.y, triangle.p1.x)
            val p2 = Coordinate(triangle.p2.y, triangle.p2.x)
            val p3 = Coordinate(triangle.p3.y, triangle.p3.x)

            val minX = minOf(p1.x, p2.x, p3.x)
            val minY = minOf(p1.y, p2.y, p3.y)
            val maxX = maxOf(p1.x, p2.x, p3.x)
            val maxY = maxOf(p1.y, p2.y, p3.y)

            for (y in minY..maxY) {
                for (x in minX..maxX) {

                    val p = Coordinate(y, x)
                    if (isPointInsideOfFigure(p, p1, p2, p3)) {

                        val newElement = placeholderGetter()
                        tryToChangeElement(p, newElement, grid)
                    }
                }
            }
        }

        fun drawCircleOnGrid(
            circle: Circle,
            grid: ArrayList<ArrayList<String>>,
            placeholderGetter: () -> String) {

            val radius = circle.radius.toInt()
            val center = circle.origin

            for (y in center.y - radius..center.y + radius) {
                for (x in center.x - radius..center.x + radius) {

                    val dx = x - center.x
                    val dy = y - center.y

                    if (dx * dx + dy * dy <= radius * radius) {

                        val reverseCoordinate = Coordinate(y, x)
                        val newElement = placeholderGetter()
                        tryToChangeElement(reverseCoordinate, newElement, grid)
                    }
                }
            }
        }

        private fun tryToChangeElement(
            coordinate: Coordinate,
            newElement: String,
            grid: ArrayList<ArrayList<String>>) {
            try {
                grid[coordinate.y][coordinate.x] = newElement
            } catch (e: Exception){
                return
            }
        }

        /*
        Cross product will tell if p1 is on the left or the right side od the p2p3 line (- or +)
        if it is on the line the return will be 0
         */
        private fun crossProduct(p1: Coordinate, p2: Coordinate, p3: Coordinate): Int {
            return (p1.x - p3.x) * (p2.y - p3.y) -
                    (p2.x - p3.x) * (p1.y - p3.y)

        }

        /*
        Basically we are checking if a point is inside the figure with the apexes of the three point.
        If we get just positives or negatives we are inside the triangle. If we get a zero we are on the edge.
        */
        private fun isPointInsideOfFigure(
            p: Coordinate,
            apex1: Coordinate,
            apex2: Coordinate,
            apex3: Coordinate): Boolean {

            val side1 = crossProduct(p, apex1, apex2)
            val side2 = crossProduct(p, apex2, apex3)
            val side3 = crossProduct(p, apex3, apex1)

            val onlyNegativeSign = (side1 < 0) || (side2 < 0) || (side3 < 0)
            val onlyPositiveSign = (side1 > 0) || (side2 > 0) || (side3 > 0)

            return !(onlyNegativeSign && onlyPositiveSign)
        }
}