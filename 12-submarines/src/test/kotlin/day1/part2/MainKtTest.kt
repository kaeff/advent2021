package day1.part2

import com.github.stefanbirkner.systemlambda.SystemLambda
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MainKtTest {
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

        val output = SystemLambda.tapSystemOut {
            main(args)
        }.strip()

        assertThat(output).isEqualTo("""5""")
    }

    @Test
    internal fun `count single increase`() {
        assertThat(countIncreases(listOf())).isEqualTo(0)
        assertThat(countIncreases(listOf(1,2,3))).isEqualTo(0)
        assertThat(countIncreases(listOf(1,2,3,4))).isEqualTo(1)

        assertThat(countIncreases(listOf(1, 2))).isEqualTo(1)
        assertThat(countIncreases(listOf(1, 1, 2))).isEqualTo(1)
        assertThat(countIncreases(listOf(1, 3, 2))).isEqualTo(1)

        assertThat(countIncreases(listOf(1, 2, 3))).isEqualTo(2)
    }

}