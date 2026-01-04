package generics

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

private val pair: Pair<Any?, Any?> = "str" to listOf(1, 3, 8)

class GenericsInKTest {
    @Test
    fun `should wrap different values`() {

        val wrappedDecimal = WrapperClass<Int>(99)
        assertThat(wrappedDecimal._t).isEqualTo(99)

        val wrappedString = WrapperClass<String>("wrapped string")
        assertThat(wrappedString._t).isEqualTo("wrapped string")
    }

    @Test
    fun `should use the upper bound restriction in Kotlin`() {
        assertDoesNotThrow {
            val decimalSrc = object : Source<Int> {
                override fun getT(): Int = 2
            }
            val anySrc: Source<Any> = decimalSrc

            //cannot compile, cause 'Double' is not supertype of the 'Int'
            //val doubleSrc: Source<Double> = decimalSrc
        }
    }

    @Test
    fun `should use the lower bound restriction in Kotlin`() {
        assertDoesNotThrow {
            val x: Comparable<Number> = object : Comparable<Number> {
                override fun compareTo(value: Number): Int {
                    return value.toInt().compareTo(10)
                }
            }
            //it is possible regarding the lower bound restriction
            val d: Comparable<Double> = x
            d.compareTo(1.0)
        }
    }

    @Test
    fun `should perform asPairOf successfully`() {
        val actual = pair.asPairOf<String, Int>()
        assertThat(actual).isNull()
    }

    @Test
    fun `should fails on asPairOf if the cast cannot be possible`() {
       val actual = pair.asPairOf<String, List<String>>()
    }

    private inline fun <reified A, reified B> Pair<*, *>.asPairOf(): Pair<A, B>? {
        if (first !is A || second !is B) return null
        return first as A to second as B
    }

}