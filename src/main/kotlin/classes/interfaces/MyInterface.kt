package classes.interfaces

//interface vs abstract class
//in one sentence: an interface cannot store its state
//interface can implement multiple interfaces; however, an abstract class can extend just one class
//in Java and Kotlin single inheritance enable
//after Java 8, interface has default methods, is this same with the Abstract, because they can have
//abstract and non-abstract methods/functions
//interface cannot have constructor, however the abstract class has
//I can define a non-static or a non-final field in the abstract class and I can modify it, this is a state change operation
//interface cannot store own state this is important

//field data member of a class, unless specified otherwise can be private, static, public, not static tc...
//property is a field with getter and setter combination
//interface properties are abstract in KOTLIN

//difference Java and Kotlin interfaces:
//in Java, the interface fields are constant, however in Kotlin these are may properties, and abstract ones

interface MyInterface {
    //it is not possible
    //property initialization not allowed in interface
    //val x: Int = 2
    //contrast with Java, it is not a constant

    val field: Int
}