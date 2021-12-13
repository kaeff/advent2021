package caves

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class CaveNetworkAcceptanceTest {
    @Test
    fun `number of routes on example network`() {
        val caveLayout = """
            start-A
            start-b
            A-c
            A-b
            b-d
            A-end
            b-end
        """.trimIndent().split("\n")
        val graph = CaveNetwork(caveLayout)

        assertEquals(10, graph.numberOfRoutes("start", "end"))
    }
}