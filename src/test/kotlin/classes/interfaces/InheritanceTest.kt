package classes.interfaces

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class InheritanceTest {

    @Test
    fun `should initiate new Child instance`() {
        assertDoesNotThrow {
            Child()
        }
    }
}