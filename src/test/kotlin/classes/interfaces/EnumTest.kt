package classes.interfaces

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class EnumTest {

    @Test
    fun `should successfully print the colors`() {
        assertDoesNotThrow {
            printAll<Color>()
        }
    }
}