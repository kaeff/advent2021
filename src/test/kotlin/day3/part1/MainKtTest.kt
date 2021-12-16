package day3.part1

import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MainKtTest {
    @Test
    internal fun `example input`() {
        val args = """
                    00100
                    11110
                    10110
                    10111
                    10101
                    01111
                    00111
                    11100
                    10000
                    11001
                    00010
                    01010
                """.trimIndent().split("\n").toTypedArray()

        val output = tapSystemOut {
            main(args)
        }.strip()

        assertThat(output).isEqualTo("198")
    }

    @Test
    internal fun `parse parses the input as a 2-dimensional list of Boolean`() {
        val args = arrayOf("00100", "11110")

        val parsed = parse(args)
        assertThat(parsed).isEqualTo(
            listOf(
                listOf(false, false, true, false, false),
                listOf(true, true, true, true, false),
            )
        )
    }

    @Test
    internal fun `test matrixRotate`() {
        assertThat(
            matrixRotate(
                listOf(
                    listOf(false, true, true),
                    listOf(true, false, true),
                )
            )
        ).isEqualTo(
            arrayOf(
                arrayOf(false, true),
                arrayOf(true, false),
                arrayOf(true, true),
            )
        )
    }

    @Test
    internal fun `gamma from the example`() {
        val input = parse(
            arrayOf(
                "00100",
                "11110",
                "10110"
                //10110 -> 22
            )
        )
        assertThat(gamma(input)).isEqualTo(22)
    }
}