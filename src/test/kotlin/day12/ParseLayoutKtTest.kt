package day12

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ParseLayoutKtTest {
    @Test
    internal fun `when layout is empty then network should be empty`() {
        assertEquals(mapOf<String, List<String>>(), parseLayout(listOf()))
    }

    @Test
    internal fun `creates a single route network`() {
        val network = parseLayout(listOf("a-b"))
        assertThat(network).isEqualTo(
            mapOf(
                "a" to setOf("b"),
                "b" to setOf("a")
            )
        )
    }

    @Test
    internal fun `creates network with 2 destination routes`() {
        val network = parseLayout(listOf("a-b", "a-c"))
        assertThat(network).isEqualTo(
            mapOf(
                "a" to setOf("b", "c"),
                "b" to setOf("a"),
                "c" to setOf("a")
            )
        )
    }
}