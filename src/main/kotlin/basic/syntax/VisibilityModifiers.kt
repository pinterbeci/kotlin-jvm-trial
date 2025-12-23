package basic.syntax

//open helps to mark a class or a class member as inheritable if I speak a class
//and overridable if I speak a variable or method
//open and private not with together it is important
//Module: IntelliJ module, a Maven project, Gradle source set (under the src/ stored files)
open class VisibilityModifiers {
    //they are: private, protected (visible in the class and the subclasses, and visible for subclass that on other package not like in Java)
    //internal (visible inside the same module) and public
    //public is the default

    private val canOverride: Boolean = true
    protected open val decimal: Int = 4
    internal open val charset: String = "custom"

    open fun greet() {
        print("hey from ${this.javaClass.name}")
    }
}

class VisibilityModifiersOverride : VisibilityModifiers() {
    override val charset: String = "override"
    override val decimal: Int = 1
    override fun greet() {
        print("greet from ${this.javaClass.name}")
    }
}

