package reflection

//reflection - set of library and language features that allows you to introspect the structure of program in runtime.
//examine itself and manipulate internal properties of the program at runtime, this is the reflection

class Factory<T>(private val clazz: Class<T>) {
    fun newInstance(): T {
        return Class.forName(clazz.name).declaredConstructors[0].newInstance() as T
    }
}

class Desk