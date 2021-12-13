package caves

class CaveNetwork(
    private val caveLayout: List<String>
) {
    fun numberOfRoutes(from: String, to: String): Int {
        return caveLayout.size + from.length + to.length
    }

}
