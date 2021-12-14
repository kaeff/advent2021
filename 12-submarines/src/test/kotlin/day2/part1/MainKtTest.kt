package day2.part1

import com.github.stefanbirkner.systemlambda.SystemLambda
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MainKtTest {
    @Test
    internal fun example() {
        val args = """
            forward 5
            down 5
            forward 8
            up 3
            down 8
            forward 2
        """.trimIndent().split("\n").toTypedArray()

        val output = SystemLambda.tapSystemOut {
            main(args)
        }.strip()

        assertThat(output).isEqualTo("150")
    }

}