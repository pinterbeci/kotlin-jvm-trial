package classes.interfaces

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `should initiate new Person instances in different ways`() {
        assertThatThrownBy {
            Person(
                age = 16,
                name = "Anna"
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("The age must be higher than 17!")

        val actual = Person(
            age = 18,
            name = "Anna"
        )
        assertThat(actual.adult).isTrue()

        assertThatThrownBy {
            Person(
                age = 19,
                name = "Cate",
                height = -1
            )
        }.isInstanceOf(IllegalArgumentException::class.java)

        val expectedHeight = 178
        val cate = Person(
            age = 19,
            name = "Cate",
            height = expectedHeight
        )
        assertThat(cate.height).isEqualTo(expectedHeight)
    }
}