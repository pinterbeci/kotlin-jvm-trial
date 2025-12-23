package basic.syntax

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class NPETest {

    @Test
    fun `should thrown a NPE if 'this' assigned in init block`() {
        assertThatThrownBy { NPEThrower() }.isInstanceOf(NullPointerException::class.java)
    }

    @Test
    fun `should thrown a NPE if I use the not-null assertion operator`() {
        assertThatThrownBy {
            CustomDecimalHolder().decimal!!
        }.isInstanceOf(NullPointerException::class.java)
    }

    @Test
    fun `should call method on nullable variable with safe call operator`() {
        //I can use the safe-call operator on val and var
        val actual = CustomDecimalHolder().decimal?.div(2)
        assertThat(actual).isNull()
    }

    @Test
    fun `should call elvis operator on nullable variable`(){
        val actual = CustomDecimalHolder().decimal ?: 1
        assertThat(actual).isEqualTo(1)
    }
}