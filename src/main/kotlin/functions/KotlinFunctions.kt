package functions

internal fun greeting(
    userId: Int = 0,
    message: () -> Unit
) {
    print(userId)
    message()
}

fun read(
    b: ByteArray,
    //default value
    len: Int = b.size,
    message: Unit? = println("no argument passed on 'message', please be aware")
) {
    println("execute read")
}

fun operationChain(
    decimal: Int,
    verify: (Int) -> Boolean,
    log: () -> Unit,
): Double {
    log()
    verify(decimal)
    return decimal / 2.0
}

fun <T> asList(vararg items: T): List<T> {
    val list = ArrayList<T>(items.size)
    for (item in items) {
        list.add(item)
    }
    return list
}

//the infix function
//not accept vararg and default valued parameters
infix fun Int.addOn(x: Int): Int = this + x

//difference between 'infix' and 'extension' function, the 'extension' function accept
//varargs and variables with default value, against the 'infix'
fun Int.with(
    x: Int = 2,
    //vararg has default value, emptyArray<T>()
    //vararg is an array, not a list
    //in Kotlin vararg have not fixed position, instead of Java (in Java the vararg must be the last argument)
    //multiple varargs does not allow
    vararg optionalDecimals: Int,
): Int {
    val sum = this + x
    return if (optionalDecimals.isNotEmpty()) optionalDecimals.sum() + sum else sum
}