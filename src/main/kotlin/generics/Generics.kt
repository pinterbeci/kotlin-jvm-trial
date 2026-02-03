package generics

class WrapperClass<T>(t: T) {
    val _t = t
}

interface Source<out T> {
    fun getT(): T
}

fun demo(strings: Source<String>) {
    val objects: Source<Any> = strings;
}

interface Comparable<in T> {
    operator fun compareTo(value: T): Int
}

//generic types are invariant, meaning that
//List<String> is not subtype of List<Object>

//if List were not INVARIANT

/*
// Java
List<String> strs = new ArrayList<String>();

// Java reports a type mismatch here at compile-time.
List<Object> objs = strs;

// What if it didn't?
// We would be able to put an Integer into a list of Strings.
objs.add(1);

// And then at runtime, Java would throw
// a ClassCastException: Integer cannot be cast to String
String s = strs.get(0);
*/

// Java
/*
void demo(Source<String> strs) {
    Source<Object> objects = strs; // !!! Not allowed in Java
}
It not works. Source<String> is not the same as the Source<Object>
To allow this assign, I could change the
void demo(Source<? extends Object> strs) {}
*/
