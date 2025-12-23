package first.steps


private fun feed(): Int = 42
internal fun generateToken(): String = ""

//default public
fun hash(s: String): String = s


open class Base {
    protected fun validate() {}
    private fun audit() {}
}

class Derived : Base() {
    fun run() {
        validate()
    }
}