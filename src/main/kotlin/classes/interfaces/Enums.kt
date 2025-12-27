package classes.interfaces

import kotlin.enums.enumEntries

//why use enums?
//set of predefined constants,
//if in the code base has repeated constant sets, instead of these sets, I use an enum

//enum can implement interfaces
enum class Color : Code {
    BLACK {
        override fun hex(): String = "#09090B"
    },
    BLUE {
        override fun hex(): String = "#2B7FFF"
    },
    GREY {
        override fun hex(): String = "#99A1AF"
    };

}

//reified - keep the generic type information in runtime
inline fun <reified T : Enum<T>> printAll() {
    enumEntries<T>().joinToString { it.name }.also { println(it) }
}

interface Code {
    fun hex(): String
}