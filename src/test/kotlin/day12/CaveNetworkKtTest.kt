package day12

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CaveNetworkKtTest {

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

    @Test
    internal fun `stopConditionExtension small caves only once one twice`() {
        assertThat(singleSmallCaveDoubleOthersOnlyOnce("a", listOf("a"))).isEqualTo(false)

        assertThat(singleSmallCaveDoubleOthersOnlyOnce("a", listOf("a", "b"))).isEqualTo(false)
        assertThat(singleSmallCaveDoubleOthersOnlyOnce("b", listOf("a", "b"))).isEqualTo(false)
        assertThat(singleSmallCaveDoubleOthersOnlyOnce("b", listOf("D", "D", "a", "b"))).isEqualTo(false)

        assertThat(singleSmallCaveDoubleOthersOnlyOnce("a", listOf("a", "a", "b"))).isEqualTo(true)
        assertThat(singleSmallCaveDoubleOthersOnlyOnce("b", listOf("a", "a", "b"))).isEqualTo(true)

    }

    @Test
    internal fun `stopConditionExtension big caves not limited`() {
        assertThat(singleSmallCaveDoubleOthersOnlyOnce("A", listOf("A", "A"))).isEqualTo(false)
    }

    @Test
    internal fun `stopConditionExtension don't go back to start`() {
        assertThat(singleSmallCaveDoubleOthersOnlyOnce("start", listOf())).isEqualTo(false)
        assertThat(singleSmallCaveDoubleOthersOnlyOnce("start", listOf("a"))).isEqualTo(true)
    }
}