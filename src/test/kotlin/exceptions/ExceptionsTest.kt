package exceptions

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import type.aliases.decimals

class ExceptionsTest {

    @Test
    fun `should require items in the list`() {
        assertThatThrownBy {
            decimals().forEach { require(it / 2 == 0) }
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `should check that all list items fit the condition`() {
        assertThatThrownBy {
            decimals().forEach { check(it > 10) }
        }.isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun `should not throw an exception if divided by zero`() {
        assertThat(divideOrNull(0)).isEqualTo(-1)
    }

    private fun divideOrNull(a: Int): Int = try {
        val b = 44 / a
        println("try block: Executing division: $b")
        b
    } catch (e: ArithmeticException) {
        println("catch block: Encountered ArithmeticException $e")
        -1
    } finally {
        println("finally block: The finally block is always executed")
    }
}