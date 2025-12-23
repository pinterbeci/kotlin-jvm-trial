package first.steps

class Outer {
    private val secret = 1

    companion object {
        private const val TRUTH = 999
    }

    class Nested {
        fun cannotTellTheSecret(): String = """
            I cannot tell the secret, cause I cannot access the Outer instance variable
            But I know the truth = $TRUTH    
            """
        //cannot access Outer.secret
    }

    inner class Inner {
        fun tellYourSecret(): Int = secret
    }
}