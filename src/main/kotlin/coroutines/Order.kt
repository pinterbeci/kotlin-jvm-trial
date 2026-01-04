package coroutines

import kotlinx.coroutines.delay

//coroutine - co + routine = cooperative + functions
//coroutine helps to perform parallel execution of multiple tasks
//instead of execute the operation synchronous, coroutine gives an opportunity
//for asynchronous programming, parallel execution of the operations
enum class Product(val description: String, val deliveryTime: Long) {
    WINDOWS("windows", 1_000),
    DOORS("doors", 1_222);
}

fun order(item: Product): Product {
    println("ORDER EN ROUTE  >>> The ${item.description} are on the way!")
    //current sleep helps to represent for an action perform time, until it not end
    //does not suspend a coroutine; it is simple blocks the execution a designated amount time.
    //it doesn't give a chance to run a runtime, and cannot suspend it
    //this function can be called from regular and suspend function as well
    Thread.sleep(item.deliveryTime)
    println("ORDER DELIVERED >>> Your ${item.description} have arrived.")
    return item
}

suspend fun suspendOrder(item: Product): Product {
    println("ORDER EN ROUTE  >>> The ${item.description} are on the way!")
    //does suspend a coroutine, that's means the current coroutine can set down its work for a designated amount of time,
    //allowing some other coroutines to run in the meantime
    //this function can only call from suspend function
    delay(item.deliveryTime)
    println("ORDER DELIVERED >>> Your ${item.description} have arrived.")
    return item
}


//represent another task execution with a sleep time, which shows how many times need for a task
fun perform(taskName: String) {
    println("STARTING TASK   >>> $taskName")
    Thread.sleep(1_000)
    println("FINISHED TASK   >>> $taskName")
}
