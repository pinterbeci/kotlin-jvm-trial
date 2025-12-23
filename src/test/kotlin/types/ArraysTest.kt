package types

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ArraysTest {
    @Test
    fun `should perform operations on the arrays and lists`() {
        val strings = mutableListOf("a", "b", "c")
        assertThat(strings.size).isEqualTo(3)

        //copy the current values and add the new one to them
        strings += "d"
        assertThat(strings.size).isEqualTo(4)
        assertThat(strings[strings.size - 1]).isEqualTo("d")

        //mutable by default
        val numbers = arrayListOf(1, 2, 99)
        numbers += 100
        assertThat(numbers.size).isEqualTo(4)

        var readOnly = listOf(5, 6, 88)
        //new list created under the hood, and IDE showed an assumption to modify the list to mutable
        readOnly += 888
        assertThat(readOnly.size).isEqualTo(4)

        var decimals: Array<Int?> = arrayOf()
        assertThat(decimals).isEmpty()
        assertThat(decimals).isNotNull()
        //every additional operation copy the existing one array and add them the new item, not so effective
        decimals += null
        decimals += 1
        decimals += 22

        assertThat(decimals.size).isEqualTo(3)

        //initiate the array with size, and the default values
        val newDecimals = Array<Int>(3) { 0 }
        assertThat(newDecimals.size).isEqualTo(3)
        assertThat(newDecimals[0]).isEqualTo(0)

        val decimalStrings = Array(5) { it -> it.toString() }
        assertThat(decimalStrings.size).isEqualTo(5)
        assertThat(decimalStrings[0]).isEqualTo("0")

        //two dimension array
        val twoDimensionArray = Array(2) { Array(2) { 0 } }
        assertThat(twoDimensionArray[0]).isEqualTo(arrayOf(0, 0))
        assertThat(twoDimensionArray[0][0]).isEqualTo(0)

        //arrays in Kotlin mutable

        val stepWith10 = arrayOf(0, 10, 20)
        val stepWith5 = arrayOf(0, 5, 10)

        //Dangerous array comparison, IDE said, instead of use the contentEquals
        println(stepWith5 == stepWith10)
        assertThat(stepWith10.contentEquals(stepWith5)).isFalse()

        //there are a lot of dedicated array types
        val booleans = BooleanArray(2) { true }
        booleans.forEach { print(it) }
    }

}