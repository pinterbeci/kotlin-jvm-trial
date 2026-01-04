package classes.interfaces

interface I


//JVM boxing rule in inline classes is same with the primitive types
//inline class is boxed, when it used as another type
//unboxed inline class is used when value is statically known to be inline class

//value class VS inline
//when the identity does not matter then create a new value class
//value classes are immutable
//value class main purpose for support a more specific domain structure, when does not matter the identity

@JvmInline
value class Foo(val i: Int) : I

fun asInline(f: Foo) {}
fun <T> asGeneric(x: T) {}
fun asInterface(i: I) {}
fun asNullable(i: Foo?) {}

fun <T> id(x: T): T = x

fun test(f: Foo) {
    asInline(f)
    asGeneric(f) // boxing
    asInterface(f) // boxing
    asNullable(f) // boxing

    val c = id(f) // boxing/unboxing, c is unboxed
}

//to be continued this topic