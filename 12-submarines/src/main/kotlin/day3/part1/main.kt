package day3.part1

fun main(args: Array<String>) {
    val input = parse(args)
    println(gamma(input) * epsilon(input))
}

fun parse(args: Array<String>): List<List<Boolean>> =
    args.map { number -> number.map { it -> it == '1' } }

fun gamma(input: List<List<Boolean>>): Int = calculateRate(input, ::selectHighestBits)

fun epsilon(input: List<List<Boolean>>): Int = calculateRate(input, ::selectLowestBits)

private fun selectHighestBits(it: Array<Boolean>) = it.filter { b -> b }.size * 2 > it.size
private fun selectLowestBits(it: Array<Boolean>) = it.filter { b -> b }.size * 2 < it.size

private fun calculateRate(input: List<List<Boolean>>, bitSelector: (Array<Boolean>) -> Boolean): Int {
    val inputRotated = matrixRotate(input)
    val selectedBits = inputRotated.map(bitSelector)
    return bitmaskToInt(selectedBits)
}

fun matrixRotate(input: List<List<Boolean>>): Array<Array<Boolean>> {
    val result = Array(input.maxOf { it -> it.size }) { Array(input.size) { false } }
    input.forEachIndexed { numberIdx, number ->
        number.forEachIndexed { bitIdx, bit ->
            result[bitIdx][numberIdx] = bit
        }
    }
    return result
}

private fun bitmaskToInt(highestBits: List<Boolean>) = highestBits.reversed()
    .foldIndexed(0, { idx, acc, b ->
        acc + if (b) 1 shl idx else 0
    })

