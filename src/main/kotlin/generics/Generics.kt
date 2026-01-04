package generics

class WrapperClass<T>(t: T) {
    val _t = t
}

interface Source<out T> {
    fun getT(): T
}

interface Comparable<in T> {
    operator fun compareTo(value: T): Int
}