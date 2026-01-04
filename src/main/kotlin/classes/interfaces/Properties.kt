package classes.interfaces


//in Kotlin the properties are used to store data and manage data without functions or classes
//properties = has a name, type, automatically has generated get() for get their value
//if the property is defined as a mutable, there are a generated set() fun for set their value

//mutable property, has a getter/setter by default
var decimal = 10

//immutable, has no setter just a getter
val pi = 3.14

class PropertyHolder {
    //calculated field without a setter
    val calculatedProperty get() = decimal * pi
    var mutableProperty: String = ""
        set(value) {
            check(value != "n/a")
            field = value
        }
}

class BankAccount(value: Int) {
    var amount = value * 340
        private set
}

class Temperature {
    private var _celsius: Double = 0.0
    var celsius: Double
        set(value) {
            _celsius = value
        }
        get() = _celsius

    var fahrenheit: Double
        get() = _celsius * 9 / 5 + 32
        set(value) { _celsius = (value - 32) * 5 / 9 }
}