package classes.interfaces

interface Base {
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(private val message: String) : Base {
    override fun printMessage() = print(message = message)
    override fun printMessageLine() = println(message = message)
}

//delegate the methods to be implemented for an implementation of Base
class DelegationPatternExecutor(b: Base) : Base by b


class DelegationPatternOverride(b: Base) : Base by b {
    override fun printMessage() {
        println("This overrides the method to be implemented!")
    }
}

