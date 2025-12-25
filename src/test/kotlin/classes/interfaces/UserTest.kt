package classes.interfaces

import classes.interfaces.User.Companion.of
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class UserTest {

    @Test
    fun `should create new User instance`() {
        println(greet)
        assertDoesNotThrow { of("Ane") }
    }
}