package day1

fun main(args: Array<String>) {
    val depthScans = args.map { it.toInt() }
    val countIncreased = countIncreases(depthScans)
    println(countIncreased)
}

fun countIncreases(depthScans: List<Int>) = depthScans
    .windowed(2)
    .map { (last, current) -> last < current }
    .count { it }