package types

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BoxingAndCachingTest {

    @Test
    fun `should run the equality check`() {
        val a = 1000
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        //referential equality
        assertThat(boxedA === anotherBoxedA).isFalse()
        //structural equality
        assertThat(boxedA == anotherBoxedA).isTrue()
    }

    @Test
    fun `should call integerCache for testing boxing conversion and integer cache`() {
        val decimal: Int? = 120
        val secondDecimal: Int? = 120

        assertThat(decimal == secondDecimal).isTrue()
        assertThat(decimal === secondDecimal).isTrue()
    }

    @Test
    fun `should try kotlin implicit conversion`() {
        val a: Int = 1    // A boxed Int (java.lang.Integer)
        //val b: Long = a //this is not possible
        val b: Long = a.toLong()  // Implicit conversion yields a boxed Long (java.lang.Long)
    }

    @Test
    fun `should try div and mod in kotlin`() {
        //modulo, after the mod (/) apply I get simple division
        assertThat(5 / 2.0).isEqualTo(2.5)

        //division, after the div operation apply get the remainder
        assertThat(5 % 2.0).isEqualTo(1.0)
    }

    @Test
    fun `should check the string pool works with kotlin`() {
        //when I want to create a new string variable and assign value to it,
        //the JVM check this stays on the String Pool or not.
        //if stays, JVM not allocates additional memory for it
        //just assign this to the new variable
        //"word" not exists in the String Pool, so JVM create a new item in the Pool, with a new memory allocation
        val word: String = "word"

        //JVM checks the String pool, and find the assigned literal, so cannot allocate additional
        //memory for them, instead of assign it to this wordCopy
        val wordCopy: String = "word"

        assertThat(word).isEqualTo(wordCopy)
        //check the memory regions are same or not
        assertThat(word).isSameAs(wordCopy)

        //I would force JVM create a new instance for me
        //string created with own memory region, and different one from above ones
        val wordObj = java.lang.String("word")

        //contents are equal
        assertThat(wordObj).isEqualTo(word)
        //actual != expected, memory location based equality check
        assertThat(wordObj).isNotSameAs(word)

        //but Java give a method 'intern' to interning a new String to the String Pool for the reassign ability
        //string is immutable, so when perform an operation on it, create a new instance from the original,
        //that's why I assign to this for a new variable
        val internedWord = wordObj.intern()
        assertThat(internedWord).isSameAs(word)

    }
}