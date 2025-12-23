package type.aliases

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

fun decimals() = listOf(1, 11, 34, 66)

class TypeAliasTest {

    @Test
    fun `should use type alias`() {
        val m: (Int) -> Boolean = { it > 0 } //{ it: Int -> it > 0 }
        val f: (Int, Boolean) -> Boolean = { decimal: Int, logical: Boolean -> decimal > 0 && logical }
        foo(m)
    }

    @Test
    fun `should replace the lambda expression`() {
        var sum = 0
        decimals().forEach(
            fun(value: Int) {
                if (value == 11) return else sum += value
            }
        )
        assertThat(sum).isEqualTo(101)
    }

    @Test
    fun `should use break on foreach`() {
        var sum = 0
        decimals().forEach { if (it == 11) return else sum += it }
        assertThat(sum).isEqualTo(1)
    }
}