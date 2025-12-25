package classes.interfaces

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class DelegationPatternTest {

    @Test
    fun `should delegate the execution`() {
        assertDoesNotThrow {
            val base = BaseImpl(message = "hey")
            DelegationPatternExecutor(b = base).printMessage()
        }
    }
}