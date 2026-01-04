package classes.interfaces


//Kotlin JVM value class is a Java value based class in short.
// Java value based class is final class which encapsulate value-types in Java, and represent immutable class.
//Immutable class - final class with final fields.
//Value based classes are identity-free;
//the implementations of the equals(), hashCode(), and toString() are solely based on the values of its instance members,
//and not from their identities, nor any other instance's state
//two value based object equality check solely based on their fields values, nor they memory regions.
//JDK value-based classes like the Optional, DateTime etc.
//look the jdk-21-trial repo Point value-based class

//value-based classes are superset of inline classes
//and they binary incompatible with inline classes

//property 'str' types define the underlying runtime representation for inline class 'Password', while in compile time will be 'Password'.

//there are a lot of restrictions of an inline class:
//must have primary constructor with a SINGLE parameter
//this single parameter must have 'val', that means read-only, which must define in the primary constructor not in the class body
//the underlying value cannot not be same type that is containing inline class:
//@JvmInline
//value class ValueClass<T : ValueClass<T>>(val value: T)*/

//inline class cannot be 'open'
//inline can implement interface
//inline cannot have backing fields (fields in the class body)
//inline class cannot have var properties
//inline class primary constructor cannot have varargs
@JvmInline
value class Password(private val str: String) {

    //it not works
    //private var hash : String
}

