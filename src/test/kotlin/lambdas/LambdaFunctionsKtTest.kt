package lambdas

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import javax.xml.transform.Source

class LambdaFunctionsKtTest {

    @Test
    fun `should reject the swap if the numbers cannot reach the minimum level`() {
        assertThatThrownBy {
            swapWithMinimum(
                source = 16,
                destination = 9,
                swap = { source, destination, minimumRequiredLevel ->
                    require(minimumRequiredLevel <= source)
                    require(minimumRequiredLevel <= destination)
                    destination
                },
                verify = { decimal -> require(decimal != null && decimal > 0) }
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `should swap the numbers`() {
        val expected = 99

        val actual = swapWithMinimum(
            source = 23,
            destination = expected,
            swap = { source, destination, requiredMinimum ->
                require(requiredMinimum <= source)
                require(requiredMinimum <= destination)
                destination
            },
            verify = { decimal -> require(decimal != null && decimal > 0) }
        )
        assertThat(actual).isEqualTo(expected)
    }

}