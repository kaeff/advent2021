package caves

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class ExtensionAcceptanceTest {

    @Test
    internal fun `visit small cave twice`() {
        val caveLayout = """
            start-A
            start-b
            A-c
            A-b
            b-d
            A-end
            b-end
        """.trimIndent().split("\n")

        val graph = CaveNetwork(caveLayout, ::singleSmallCaveDoubleOthersOnlyOnce)

        assertEquals(36, graph.numberOfRoutes("start", "end"))
    }
}