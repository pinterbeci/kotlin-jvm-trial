package basic.syntax

//Kotlin enables to declare a variable to be a 'null', or when declare a nonnull variable the compiler knows this variable
//cannot hold a null value.

//the kotlin ensure the null safety for catch the potential null-related issues in compile time rather than the runtime
//only possible cause the kotlin throws NPE, when '!!' use the not-null assertion operator
//or leaking 'this' in constructor I will a create a test for this

class NPEThrower {
    private val word: String
    init {
        this.crash()
        word = "init"
    }

    private fun crash() {
        //on the execution flow current point the 'word' as an object is not implemented yet
        //if I swap this variable to a primitive, not thrown a NPE
        word.startsWith('i')
        print("execute crash fun")
    }
}

class CustomDecimalHolder{
    val decimal : Int? = null
}