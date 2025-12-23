package first.steps

interface Repo {
    fun storedItems(): Int = 0

    fun store(item: Int)

    fun items() : List<Int>
}