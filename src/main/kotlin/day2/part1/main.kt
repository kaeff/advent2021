package day2.part1

import java.lang.RuntimeException

fun main(args: Array<String>) {
    val finalPosition = process(args)
    println(finalPosition.x * finalPosition.depth)
}

private fun process(args: Array<String>): Position = args
    .map { it.split(" ") }
    .map { (command, unit) -> Command(command, unit.toInt()) }
    .fold(Position(), { position, command -> position.accept(command) })


data class Position(val x: Int = 0 , val depth: Int = 0) {
    fun accept(command: Command): Position {
        return when (command.direction) {
            "forward" -> this.copy(x = x + command.distance)
            "down" -> this.copy(depth = depth + command.distance)
            "up" -> this.copy(depth = depth - command.distance)
            else -> throw RuntimeException("Unknown direction: ${command.direction}")
        }
    }
}

data class Command(val direction: String, val distance: Int)
