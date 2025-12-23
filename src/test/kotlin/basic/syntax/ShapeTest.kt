package basic.syntax

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ShapeTest{

    @Test
    fun `should reassigned the variables`(){
        val shape = Shape(height = 20.1, length = 5.0)
        shape.height = 22.0
        shape.length = 21.0

        assertThat(shape.perimeter).isEqualTo(50.2)

        shape.perimeter = 400.0

        assertThat(shape.height).isEqualTo(22.0)
        assertThat(shape.length).isEqualTo(21.0)
        assertThat(shape.perimeter).isEqualTo(400.0)
    }

    @Test
    fun `should calculate shape perimeter`(){
        val shape = Shape(height = 5.0, length = 10.0)
        assertThat(shape.perimeter).isEqualTo(30.0)
    }
}