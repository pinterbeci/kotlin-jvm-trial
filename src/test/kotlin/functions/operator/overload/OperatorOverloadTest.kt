package functions.operator.overload

import functions.operator.overload.Point
import functions.operator.overload.inc
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorOverloadTest {

    @Test
    fun `should successfully use the overloaded operator on Point`() {
        val actual = Point(x = 1, y = 7).inc()
        assertThat(actual.x).isEqualTo(2)
        assertThat(actual.y).isEqualTo(8)
    }
}