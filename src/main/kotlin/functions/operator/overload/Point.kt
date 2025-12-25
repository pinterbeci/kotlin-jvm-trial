package functions.operator.overload

data class Point(val x: Int, val y: Int)
operator fun Point.inc(): Point = this.copy(x = this.x + 1, y = this.y + 1)