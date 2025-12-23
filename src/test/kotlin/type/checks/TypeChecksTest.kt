package type.checks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class TypeChecksTest {

    @Test
    fun `should check types`() {
        assertThat(6 is Number).isTrue()
        assertThat("" is String).isTrue()
    }

    @Test
    fun `should clean the rooms`() {
        assertDoesNotThrow {
            val robot = RobotVacuum(rooms = listOf("bedroom", "bathroom", "kitchen"))
            var status: Status = robot.status()

            while (status is Ok) {
                print("Start cleaning the ${status.currentRoom}")
                status = robot.clean()
            }
        }
    }
}