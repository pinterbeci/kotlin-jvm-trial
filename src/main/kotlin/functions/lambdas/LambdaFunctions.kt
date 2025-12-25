package functions.lambdas


fun swapWithMinimum(
    source: Int,
    destination: Int?,
    swap: (source: Int, destination: Int, requiredMinimum: Int) -> Int,
    verify: (Int?) -> Unit
): Int {
    verify(source)
    verify(destination)
    return swap(source, destination!!, 10)
}
