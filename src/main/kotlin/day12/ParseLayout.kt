package day12

fun parseLayout(caveLayout: List<String>): Map<String, Set<String>> {
    val connections = caveLayout
        .map { it.split("-") }
        .map { (from, to) -> from to to }

    val inverseConnections = connections.map { (from, to) -> to to from }

    return (connections + inverseConnections).fold(mapOf(), { network, (from, to) ->
        network + (from to network.getOrDefault(from, emptySet()) + to)
    })
}
