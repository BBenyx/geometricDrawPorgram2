package commands

import IO.OutputHandler
import visitors.CanvasVisitor

class SetRenderType(val renderType: CanvasVisitor, val outputHandler: OutputHandler): Command {
    override fun execute() {
        outputHandler.setRenderType(renderType)
    }
}