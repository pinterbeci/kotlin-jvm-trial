package classes.interfaces


//sealed class or interface - restrict who can directly inherit
//compiler knows: which classes can inherit the interface
//In Kotlin, classes are final by default, which means they cannot be inherited

//short comparison with Java
//in Java the 'sealed' can be used with an interface or an abstract class (that's important)
//When I define a sealed class or interface, I must list direct classes that inherit it.
//for this list action Java provide the 'permits' keyword

//regarding the classes which extend a sealed class or implement a sealed interface define with:
//final, sealed or non-sealed keyword

//the 'sealed' helps the execution of  when()/switch(), because no longer need else branch, the compiler knows who extended/implemented
//the sealed interface/class
sealed interface Error {
    fun show(): String
}

class IOError : Error {
    override fun show(): String = "IO error!"
}

class ArgumentError : Error {
    override fun show(): String = "Argument error!"
}