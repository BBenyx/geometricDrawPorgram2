data class Coordinate(val x: Int, val y: Int): Comparable<Coordinate> {

    private fun distanceSquared(): Double {
        return x.toDouble() * x.toDouble() + y.toDouble() * y.toDouble()
    }

    override fun compareTo(other: Coordinate): Int {
        return this.distanceSquared().compareTo(other.distanceSquared())
    }
}