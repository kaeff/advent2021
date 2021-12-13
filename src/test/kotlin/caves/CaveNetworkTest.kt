package caves

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CaveNetworkTest {

    @Test
    fun `single-route network`() {
        val caveLayout = """
            start-end
        """.trimIndent().split("\n")
        val graph = CaveNetwork(caveLayout)

        assertThat(graph.allRoutes("start", "end").first()).isEqualTo(listOf("start", "end"))
    }

    @Test
    fun `network with intermediate stop`() {
        val caveLayout = """
            start-im
            im-end
        """.trimIndent().split("\n")
        val graph = CaveNetwork(caveLayout)

        assertThat(graph.allRoutes("start", "end").first()).isEqualTo(listOf("start", "im", "end"))
    }

    @Test
    fun `network with dead end stop`() {
        val caveLayout = """
            start-im
            im-dead
            im-end
        """.trimIndent().split("\n")
        val graph = CaveNetwork(caveLayout)

        assertThat(graph.allRoutes("start", "end").first()).isEqualTo(listOf("start", "im", "end"))
    }

    @Test
    internal fun `visit capital letter stations twice`() {
        val caveLayout = """
            start-A
            A-b
            A-end
        """.trimIndent().split("\n")
        val graph = CaveNetwork(caveLayout)

        assertThat(graph.allRoutes("start", "end")).contains(
            listOf("start", "A", "end"),
            listOf("start", "A", "b", "A", "end")
        )
    }
}