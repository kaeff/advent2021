package day1

import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day1KtTest {
    @Test
    internal fun example() {
        val args = """
            199
            200
            208
            210
            200
            207
            240
            269
            260
            263
        """.trimIndent().split("\n").toTypedArray()

        val output = tapSystemOut {
            main(args)
        }.strip()

        assertThat(output).isEqualTo("""7""")
    }

    @Test
    internal fun `count single increase`() {
        assertThat(countIncreases(listOf())).isEqualTo(0)
        assertThat(countIncreases(listOf(1))).isEqualTo(0)

        assertThat(countIncreases(listOf(1,2))).isEqualTo(1)
        assertThat(countIncreases(listOf(1, 1, 2))).isEqualTo(1)
        assertThat(countIncreases(listOf(1, 3, 2))).isEqualTo(1)

        assertThat(countIncreases(listOf(1, 2, 3))).isEqualTo(2)
    }
}