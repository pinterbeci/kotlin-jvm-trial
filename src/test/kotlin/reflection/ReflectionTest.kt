package reflection

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class ReflectionTest {
    @Test
    fun `should initiate new instance via reflection`() {
        assertDoesNotThrow {
            val factory = Factory<Desk>(Desk::class.java)
            val desk = factory.newInstance()

            assertThat(desk is Desk).isTrue()
        }
    }
}