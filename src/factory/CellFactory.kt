package factory
import Cell
import IO.InputHandler

object CellFactory: Factory<Cell> {
    override fun create(): Cell {
        val placeholder =
            InputHandler.notEmptyStringInput("Enter the placeholder character (eg: #): ")[0].toString()
        val color =
            InputHandler.rgbInput("Enter an RGB for color (eg: 122,255,0): ")

        return Cell(placeholder, color)
    }
}