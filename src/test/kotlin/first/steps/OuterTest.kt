package first.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OuterTest {

    @Test
    fun `should initiate inner class and tell the secret`() {
        val outer = Outer()
        val inner = outer.Inner()
        assertThat(inner.tellYourSecret()).isEqualTo(1)
    }

    @Test
    fun `should obtain the nested instance as a static instance, cause it knows the truth`() {
        val actual = Outer.Nested().cannotTellTheSecret()
        assertThat(actual).contains("truth")
    }
}