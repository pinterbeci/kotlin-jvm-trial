package classes.interfaces


interface Factory<T> {
    fun createNewInstance(): T
}

class User private constructor(private val name: String) {
    //defines a companion object that acts as a factory for create a new User instance
    //companion object is independent by instances
    //by default companion object name is Companion, but this is not strict
    //it can be renamed

    //companion object is singleton object that's associated a single class
    //on JVM it becomes a static nested class
    companion object : Factory<User> {
        fun of(name: String): User = User(name)

        //create new instance with default name
        override fun createNewInstance(): User = User("")
    }
}

//object expression extend the Any class, which already has a toString()
val greet = object {
    private val message = "hi everyone!"
    override fun toString(): String = message
}
