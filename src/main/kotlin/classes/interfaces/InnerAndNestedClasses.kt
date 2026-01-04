package classes.interfaces

class Outer {
    private val bar: Int = 1

    class Nested {

        //fun showBar() = this.bar

        //the nested class cannot access outer class element directly
        fun foo() = Outer().showBar()
    }

    inner class Inner {
        //instead of nested class, the Inner class can access the outer class elements
        fun showBar() = bar
    }

    fun showBar() = bar
}