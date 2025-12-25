package classes.interfaces

//class with primary constructor, which parameters are variables
class Person(val age: Int, val name: String) {
    //multiple init blocks
    //these are execute in order, when they appear
    init {
        println("new Person instance created")
    }

    init {
        require(age > 17) { "The age must be higher than 17!" }
    }

    val adult: Boolean
        get() {
            return age > 17
        }
    var height: Int? = null
       private set(value) {
            require(value != null) { "The height must not be unknown!" }
            require(value > 0) { "The height must not be lower than zero!" }
            field = value
        }

    //secondary constructor, which must call the primary constructor
    //in Java the secondary constructor first line must be the primary call seems like this
    //this(....)
    //and then set additional values
    constructor(age: Int, name: String, height: Int) : this(
        age = age,
        name = name
    ) {
        this.height = height
    }

    constructor() : this(age = 0, name = "") {
        //indirect delegation, call the primary constructor with default values
    }

    constructor(age: Int) : this(age = age, name = "") {
        //secondary constructor with direct delegation
    }
}

class MainCharacter {
    val role: String

    init {
        println("run before the secondary constructor")
        //cannot validate the field because it is not initialised yet
        //require(role.isNotBlank())
    }

    //the secondary constructor converted to primary one
    constructor(role: String) {
        this.role = role
    }
}