package day2.part2

fun main(args: Array<String>) {
    val finalPosition = process(args)
    println(finalPosition.horizontal * finalPosition.depth)
}

private fun process(args: Array<String>): Position = args
    .map { it.split(" ") }
    .map { (command, unit) -> Command(command, unit.toInt()) }
    .fold(Position(), { position, command -> position.accept(command) })


data class Position(val horizontal: Int = 0, val depth: Int = 0, val aim: Int = 0) {
    fun accept(command: Command): Position {
        return when (command.direction) {
            "down" -> this.copy(aim = aim + command.distance)
            "up" -> this.copy(aim = aim - command.distance)
            "forward" -> this.copy(
                horizontal = horizontal + command.distance,
                depth = depth + aim * command.distance
            )
            else -> throw RuntimeException("Unknown direction: ${command.direction}")
        }
    }
}

data class Command(val direction: String, val distance: Int)
