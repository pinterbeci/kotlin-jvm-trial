package first.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ServiceTest {

    @Test
    fun `should initiate new instance`() {
        val expected = "key"
        val service = Service.of(key = expected)
        assertThat(service.obtainKey()).isEqualTo(expected)
    }
}