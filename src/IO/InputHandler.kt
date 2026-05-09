package IO
import Coordinate
import RGB

object InputHandler {

    fun notEmptyStringInput(message: String): String {
        print(message)
        var value = readln().trim()
        while(value.isEmpty()) {
            print("ERROR: Input cannot be none! $message")
            value = readln().trim()
        }
        return value
    }

    fun intInput(message: String): Int {

        print(message)
        var value = readln().trim()
        while (tryToParseIntoInt(value) == null) {
            print("ERROR: Input is not a number! $message")
            value = readln().trim()
        }
        return value.toInt()
    }

    fun uIntInput(message: String): UInt {

        print(message)
        var value = readln().trim()
        while (tryToParseIntoUInt(value) == null) {
            print("ERROR: Input is not a positive number! $message")
            value = readln().trim()
        }
        return value.toUInt()
    }

    fun coordinateInput(message: String): Coordinate {

        print(message)
        var coordinates: List<String> = readln().trim().split(",")
        while (
            coordinates.size != 2 ||
            tryToParseIntoInt(coordinates[0].trim()) == null ||
            tryToParseIntoInt(coordinates[1].trim()) == null) {

            print("ERROR: Input is not a coordinate! $message")
            coordinates = readln().trim().split(",")
        }
        return Coordinate(coordinates[0].trim().toInt(), coordinates[1].trim().toInt())
    }

    fun rgbInput(message: String): RGB {

        print(message)
        var rgb: List<String> = readln().trim().split(",")
        while (
            rgb.size != 3 ||
            tryToParseIntoUByte(rgb[0].trim()) == null ||
            tryToParseIntoUByte(rgb[1].trim()) == null ||
            tryToParseIntoUByte(rgb[2].trim()) == null) {

            print("ERROR: Input is not an RGB! $message")
            rgb = readln().trim().split(",")
        }
        return RGB(
            rgb[0].trim().toUByte(),
            rgb[1].trim().toUByte() ,
            rgb[2].trim().toUByte())
    }

    private fun tryToParseIntoUByte(element: String): UByte? {
        return try {
            element.toUByte()
        } catch (e: NumberFormatException) {
            null
        }
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