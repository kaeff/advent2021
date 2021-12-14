package day1.part2

fun main(args: Array<String>) {
    val depthScans = args.map { it.toInt() }
    val countIncreased = countIncreases(depthScans)
    println(countIncreased)
}

fun countIncreases(depthScans: List<Int>) = depthScans
    .windowed(3)
    .map { it.sum()}
    .windowed(2)
    .map { (last, current) -> last < current }
    .count { it }