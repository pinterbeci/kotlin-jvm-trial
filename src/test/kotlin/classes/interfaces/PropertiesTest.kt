package classes.interfaces

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class PropertiesTest {

    @Test
    fun `should check calculated property`() {
        val shape = PropertyHolder()
        assertThat(shape.calculatedProperty).isEqualTo(pi * decimal)

        //call the defined setter
        assertThatThrownBy {
            shape.mutableProperty = "n/a"
        }
    }

    @Test
    fun `should retain the counted amount`() {
        val actual = BankAccount(2433).amount
        assertThat(actual).isEqualTo(827220)
    }

    @Test
    fun `should calculate temperature`() {
        val temperature = Temperature()
        temperature.celsius = 24.0
        assertThat(temperature.fahrenheit).isEqualTo(75.2)
    }
}