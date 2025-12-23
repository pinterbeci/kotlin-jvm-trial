package idioms

//data class provide by default getter/setter, equals/hashCode and copy method
//regarding these methods, like the equals or hashCode use the class variables, so this is why must
//declare at least one constructor parameter, which is a variable
//without val in the constructor, just a simple parameter, that possible to use in the init{}
data class Customer(val name: String, val email: String)

//I could add a default value for the function/constructor parameter
//if I would override this value on the caller side, I can do
fun foo(name: String = "") {
    //string interpolation
    print("Name = $name")
    higherFunc("by from the idioms.fun", ::print)
}


//higher-order function and lambdas are treated like objects
//this means they can up the memory, which slow down the program
//so the inline helps to solve this memory issue, and tells the compiler, don't create separate
//memory space for this, instead copy the code directly where the function called
//higher-order function is that get a method call as a parameter
//in short: we can tell the compiler, copy that function's code in the caller-side without creating a object
inline fun higherFunc(string: String, myCall: (String) -> Unit) {
    myCall(string)
}

fun callReadline() {
    val decimal = readln().toIntOrNull()
    print("Read decimal = $decimal")
}



