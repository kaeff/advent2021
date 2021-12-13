package caves

class CaveNetwork(
    private val caveLayout: List<String>
) {
    private val network = parseLayout(caveLayout)

    fun numberOfRoutes(from: String, to: String): Int {
        return allRoutes(from, to).size
    }

    fun allRoutes(from: String, to: String): Set<List<String>> {
        return visit(from, to, emptyList()).toSet()
    }

    private fun visit(station: String, to: String, stationsVisited: List<String>): List<List<String>> {
        val connectingStations = network[station] ?: return emptyList()
        return if (station == to) {
            listOf(stationsVisited + station)
        } else {
            val toVisit = connectingStations - stationsVisited.filter { it.any { c -> c.isLowerCase() } }.toSet()
            toVisit
                .map { visit(it, to, stationsVisited + station) }
                .fold(listOf()) { acc, el -> acc + el }

        }
    }

}
