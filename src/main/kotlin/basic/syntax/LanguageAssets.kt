package basic.syntax

import java.time.LocalDate

fun iterations() {
    for (word in listOf("first", "second", "third")) {
        print("current word = $word")
    }
    var sumOfDecimals = 0
    for (decimal in listOf(1, 2, 255, 666)) sumOfDecimals += decimal

    print("Sum Of Decimals = $sumOfDecimals")

    val sumOfDoubles = listOf(2.0, 1.22, 5.888).sumOf { it }
    print("Sum Of Doubles = $sumOfDoubles")

    val names = listOf("Anna", "Peter", "Shane")
    var index = 0
    while (index < names.size) {
        print("Current name = ${names[index]}")
        index++
    }

    var alphabets = ""
    for (alphabet in 'a'..'u') alphabets += alphabet
}

fun whenExpression(name: String) = when (name) {
    "Anna" -> print("hello + $name")
    "Peter" -> print("hi + $name")
    "Tician" -> print("good morning + $name")
    "Tristan" -> print("hey + $name")
    else -> print("I don't know you, but hello")
}

fun inRangeWithDates() {
    val now = LocalDate.now()
    val oneYearLater = now.plusYears(1)

    //(now..oneYearLater) when I want to use this, under the hood a ClosedRange<LocalDate> is created.
    //the ClosedRange<LocalDate> it is not iterable, like the IntRange, DoubleRange, CharRange

    //with the generateSequence helps to iterate a ClosedRange<LocalDate>
    for (date in generateSequence { now..oneYearLater }) {
        print("On date = $date")
    }
}



