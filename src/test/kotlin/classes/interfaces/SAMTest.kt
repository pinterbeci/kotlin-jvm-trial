package classes.interfaces

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class SAMTest {
    @Test
    fun `should use functional interface`() {
        assertDoesNotThrow {
            val greet = Greet {
                fun sayHi() {
                    println("hello bello itt a melo")
                }
            }
            val polite = Greet { println("Good morning everyone!") }
        }
    }

    @Test
    fun `should show a simple interface initialization`() {
        assertDoesNotThrow {
            val goodNews = object : Display {
                override fun message() {
                    println("good news!")
                }
            }
        }
    }
}