import commands.Command

class History(private val commands: ArrayList<Command> = ArrayList()) {

    fun add(command: Command) = commands.add(0, command)

    fun pop(): Command? {
        if (commands.isEmpty()) return null
        return commands.removeAt(0)
    }

    fun peak(): Command? {
        if (commands.isEmpty()) return null
        return commands[0]
    }
}