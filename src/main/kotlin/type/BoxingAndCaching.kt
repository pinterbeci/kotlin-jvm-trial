package type

fun equalityCheck() {
    val a: Int = 1000
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    //referential equality,
    //check two object points the same object or not
    //in Java this is the '=='
    println(boxedA === anotherBoxedA)
    //structural equality
    //check for the  equals function
    //check for two object has same CONTENT
    //in Java this is the equals
    println(boxedA == anotherBoxedA)

    //Java opposite:
    /*
        String s1 = new String( "Test" );
        String s2 = new String( "Test" );

        //Kotlin '==='
        System.out.println( s1 == s2 ); // false
        //Kotlin '=='
        System.out.println( s1.equals( s2 )); // true
     */
}

fun integerCache() {

    //Java the Integer pool as similar as the String but, there is a boundary
    //in this Integer pool can strore a values between -128..127, if I add a primitive value to the reference
    //under the hood this:
    val decimal: Int = 120
    //call this Integer.valueOf(120), check the implementation,
    //there is a check if I would add a value between -128..127, the Java read from cache
    //this is why two reference is equal if they are store value from this range
    val secondDecimal: Int = 120

    println(decimal == secondDecimal)
    println(decimal === secondDecimal)
}