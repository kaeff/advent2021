package day12

class CaveNetwork(
    caveLayout: List<String>,
    private val stopCondition: (String, List<String>) -> Boolean = ::smallCavesOnlyOnce
) {
    private val network = parseLayout(caveLayout)

    fun numberOfRoutes(from: String, to: String): Int {
        return allRoutes(from, to).size
    }

    fun allRoutes(from: String, to: String): Set<List<String>> {
        return visit(from, to, emptyList()).toSet()
    }

    private fun visit(
        station: String,
        to: String,
        stationsVisited: List<String>
    ): List<List<String>> {
        val connectingStations = network[station] ?: return emptyList()
        return if (station == to) {
            listOf(stationsVisited + station)
        } else {
            connectingStations
                .filter { !stopCondition(it, stationsVisited) }
                .map { visit(it, to, stationsVisited + station) }
                .fold(listOf()) { acc, el -> acc + el }
        }
    }
}

fun smallCavesOnlyOnce(station: String, stationsVisited: List<String>) =
    station.all { it.isLowerCase() } && stationsVisited.contains(station)

fun singleSmallCaveDoubleOthersOnlyOnce(station: String, stationsVisited: List<String>): Boolean {
    return if (station.any { it.isUpperCase() }) {
        false
    } else if (station == "start" && stationsVisited.isNotEmpty()) {
        true
    } else {
        val smallStationsVisited = stationsVisited.filter { it.all { c -> c.isLowerCase() } }
        val visitedStationsByCount = (smallStationsVisited + station).groupingBy { it }.eachCount()
        val stationsVisitedMoreThanOnce = visitedStationsByCount.filter { (_, v) -> v >= 2 }
        val anyStationVisitedMoreThanTwice = stationsVisitedMoreThanOnce.any { (_, v) -> v > 2 }

        stationsVisitedMoreThanOnce.size > 1 || anyStationVisitedMoreThanTwice
    }
}
