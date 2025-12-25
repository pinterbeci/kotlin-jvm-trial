package classes.interfaces

sealed interface Error{
    fun show(): String
}


class NonSealedClass : Error {
    override fun show(): String {
        TODO("Not yet implemented")
    }
}