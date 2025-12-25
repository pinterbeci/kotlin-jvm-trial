package classes.interfaces

//inherit the Any, like in Java Object
//Any has three methods: equals, hashCode, toString
class Example

//open shows, this class would be inheritable
//by default Kotlin classes and functions, and properties are FINAL's
open class Parent {
    init {
        println("init new Parent instance")
    }
}

//if the Child has no primary constructor, then every secondary constructor must to call super(), the parent class
//so when a child is initialized, it must be initiated parent class as well
class Child : Parent {
    //in Java, child class constructor first line must be the 'super()' call

    //this became the primary constructor
    constructor() {
        //by default call the Parent constructor
        println("init new Child instance")
    }
}

open class Rectangle {
    open fun draw() { /* ... */
    }
}

interface Polygon {
    fun draw() { /* ... */
    } // interface members are 'open' by default
}

//call the Rectangle class constructor
//and implements the Polygon interface
//however in Java's extends and implements keywords
class Square : Rectangle(), Polygon {
    // The compiler requires draw() to be overridden:
    // the Square must override the draw(), because it inherits many implementations of it
    //so there are two different implementation, what the Square inherits regarding the draw, and it is confusing
    override fun draw() {
        super<Rectangle>.draw() // call to Rectangle.draw()
        super<Polygon>.draw() // call to Polygon.draw()
    }
}