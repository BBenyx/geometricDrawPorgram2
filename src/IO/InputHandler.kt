package IO
import Coordinate
import IO.Color

class InputHandler {

    fun stringInput(message: String): String {
        println(message)
        return readln().trim()
    }

    fun intInput(message: String): Int {

        println(message)
        var value = readln().trim()
        while (tryToParseIntoInt(value) == null) {
            println("ERROR: Input is not a number! $message")
            value = readln().trim()
        }
        return value.toInt()
    }

    fun uIntInput(message: String): UInt {

        println(message)
        var value = readln().trim()
        while (tryToParseIntoUInt(value) == null) {
            println("ERROR: Input is not a positive number! $message")
            value = readln().trim()
        }
        return value.toUInt()
    }

    fun coordinateInput(message: String): Coordinate {

        println(message)
        var coordinates: List<String> = readln().trim().split(",")
        while (
            coordinates.size != 2 &&
            tryToParseIntoInt(coordinates[0].trim()) != null &&
            tryToParseIntoInt(coordinates[1].trim()) != null) {

            println(coordinates[0])
            println(coordinates[1])
            println("ERROR: Input is not a coordinate! $message")
            coordinates = readln().trim().split(",")
        }
        return Coordinate(coordinates[0].trim().toInt(), coordinates[1].trim().toInt())
    }

    private fun tryToParseIntoInt(element: String): Int? {
        return try {
            element.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }

    private fun tryToParseIntoUInt(element: String): UInt? {
        return try {
            element.toUInt()
        } catch (e: NumberFormatException) {
            null
        }
    }
}