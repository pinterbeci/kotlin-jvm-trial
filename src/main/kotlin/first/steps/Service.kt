package first.steps

class Service private constructor(private var key: String) {
    companion object {
        fun of(key: String): Service = Service(key)
    }
    fun obtainKey() : String = key
}