package functions

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class KotlinFunctionsKtTest {

    @Test
    fun `should greet the user for two calling modes`() {
        assertDoesNotThrow {
            greeting(
                userId = 1,
                message = {
                    print("\nhello bello mr/mrs")
                }
            )
        }
        //trailing lambda with default parameter value
        println("\ncalling greeting{}, with default userId = 0")
        assertDoesNotThrow {
            greeting { print("\nhello bello mr/mrs") }
        }

        println("\ncalling greeting{}, with named variable + trailing lambda")
        assertDoesNotThrow {
            greeting(userId = 2) { print("\nhello bello mr/mrs") }
        }
    }

    @Test
    fun `should execute read function`() {
        assertDoesNotThrow {
            read(b = ByteArray(10))
        }

        assertDoesNotThrow {
            read(b = ByteArray(10), len = 8)
        }

        assertDoesNotThrow {
            read(b = ByteArray(10), len = 8, message = print("all arguments are filled"))
        }
    }

    @Test
    fun `should perform execution chain`() {
        assertThatThrownBy {
            operationChain(
                decimal = -6,
                verify = { decimal -> if (decimal > 0) true else throw IllegalArgumentException("The given value must be greater than zero!") },
                log = { print("execute the operation chain") }
            )
        }
    }

    @Test
    fun `should work my asList function`() {
        val actual = asList(1, 24, 99, 99999)
        assertThat(actual).isNotEmpty
        assertThat(actual.size).isEqualTo(4)
        assertThat(actual).doesNotContain(7)
    }

    @Test
    fun `should add two decimals with the shl infix function`() {
        assertThat(1.addOn(2)).isEqualTo(3)
    }

    @Test
    fun `should bypass vararg if it is default`() {
        assertThat(1.with(x = 3)).isEqualTo(4)
    }

    @Test
    fun `should consider varargs if not empty`() {
        1.with(
            x = 4,
            optionalDecimals = intArrayOf(1, 2, 4)
        )
    }

    @Test
    fun `should refer to a method with a double colon`() {
        val actual = refersTo(4, Int::inc)
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `should execute anonymous extension function`() {
        //name that I invoke in an Int with the corresponding parameters
        val isInRange: Int.(min: Int, max: Int) -> Boolean = { min, max -> this in min..max }
        assertThat(5.isInRange(1, 10)).isTrue()
        assertThat(20.isInRange(1, 10)).isFalse()
    }
}