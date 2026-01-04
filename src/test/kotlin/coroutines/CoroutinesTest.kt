package coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.yield
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

//many thanks for the coroutines.article writer
private const val article = "https://typealias.com/start/kotlin-coroutines"


//IMPORTANT!!!!
//every test is run on a single thread
class CoroutinesTest {
    @Test
    fun `should ask a mate to construct my new house`() {
        println("This test increases the test suite execution time with a lot, because I represented here a synchronous execution flow with Thread.sleep(...)")
        assertDoesNotThrow {
            val windows = order(Product.WINDOWS)
            val doors = order(Product.DOORS)
            perform("laying bricks")
            perform("installing ${windows.description}")
            perform("installing ${doors.description}")
        }
    }

    @Test
    fun `should ask a mate to construct my new house with suspend functions`() = runTest {
        printThread()
        assertDoesNotThrow {
            runBlocking {
                printThread()

                val windows = suspendOrder(Product.WINDOWS)
                printThread()
                val doors = suspendOrder(Product.DOORS)
                printThread()

                perform("laying bricks")
                perform("installing ${windows.description}")
                perform("installing ${doors.description}")

                printThread()
            }
        }
        printThread()
    }


    @Test
    fun `should ask the a mate to construct my new house with separate coroutines`() = runTest {
        //that's good
        // the `should ask a mate to construct my new house with suspend functions`
        //`should ask a mate to construct my new house`
        //test functions result difference the runtime, the first is more effective than the second.
        //but the second did not run asynchronous because of the actions did run with the same coroutine
        //had no any separated coroutine, which can be suspended 'suspendOrder',
        // because the whole operation flow used one coroutine

        //that's why put into launch{} the functions, that's use 'suspendOrder'
        printThread()
        assertDoesNotThrow {
            runBlocking {
                printThread()

                val windows = launch {
                    printThread()
                    suspendOrder(Product.WINDOWS).also {
                        printThread()
                    }
                }

                val doors = launch {
                    printThread()
                    suspendOrder(Product.DOORS).also {
                        printThread()
                    }
                }

                launch {
                    printThread()

                    perform("laying bricks")

                    //but these variable returns value became 'Job' instead of 'Order'
                    //perform("installing ${windows.description}")
                    //perform("installing ${doors.description}")
                    printThread()
                }
                printThread()
            }
        }
        printThread()
    }

    @Test
    fun `should ask the a mate to construct my new house with async`() = runTest {
        printThread()
        assertDoesNotThrow {
            runBlocking {
                printThread()
                println("Starting of the runBlocking")

                //async {} - returns a Deferred<> instead of launch{} Job
                // Deferred value is a non-blocking cancellable future. it is a Job with a result.
                //this interface gives us a function 'await()', which allows us to get results of
                //a current task, which run separately
                val windows = async {
                    printThread()
                    println("Starting of the first async block")

                    suspendOrder(Product.WINDOWS).also {
                        printThread()
                        println("End of the first aync block")
                    }
                }

                val doors = async {
                    printThread()
                    println("Starting of the second async block")

                    suspendOrder(Product.DOORS).also {
                        printThread()
                        println("End of the second async block")
                    }
                }

                launch {
                    println("Starting of the launch block")
                    printThread()

                    perform("laying bricks")


                    //the await() functions suspends this launch{}, until
                    //they not get results until the async{} are finished
                    perform("installing ${windows.await().description}")
                    perform("installing ${doors.await().description}")

                    printThread()
                    println("End of the launch block")
                }
                printThread()
                println("End of the runBlocking")
            }
        }
        printThread()
    }

    @Test
    fun `should successfully run my first coroutine and print`() {
        //runBlocking - creates and run a coroutine
        //this kind of function calls a coroutine builder
        //the 'runBlocking' execution is blocking the caller thread (the actual thread which called the test method) until it is not finishing execution
        runBlocking {
            println("Sledge: Suplex!")
            println("Hammer: Clothesline!")
            println("Sledge: Figure-four Leglock!")
            println("Hammer: Piledriver!")
            println("Sledge: Pinning 1-2-3!")
        }
    }

    //runTest{} - test for coroutines, helps to cannot block the OS thread
    @Test
    fun `should not perform concurrent execution flow with nested coroutine`() = runTest {
        val expected = listOf(
            "Sledge: Suplex!",
            "Hammer: Clothesline!",
            "Sledge: Figure-four Leglock!",
            "Hammer: Piledriver!",
            "Sledge: Pinning 1-2-3!"
        )

        val actual = mutableListOf<String>()
        runBlocking {
            //create a coroutine from within another coroutine:
            // runBlocking {
            //              println("Sledge: Suplex!")
            //              println("Sledge: Figure-four Leglock!")
            //              println("Sledge: Pinning 1-2-3!")
            //}
            //->
            //  runBlocking {
            //              println("Hammer: Clothesline!")
            //              println("Hammer: Piledriver!")
            //}
            runBlocking {
                actual.add("Hammer: Clothesline!")
                actual.add("Hammer: Piledriver!")
            }
            actual.add("Sledge: Suplex!")
            actual.add("Sledge: Figure-four Leglock!")
            actual.add("Sledge: Pinning 1-2-3!")

            //one problem with this outer coroutine builder is waiting until the nested/inner coroutine not finish,
            //and then moving on, like a simple code execution, the actions are performing where they appear,
            //but under the hood two coroutine created, let's move to another test
        }
        assertThat(actual).isNotEqualTo(expected)
    }

    @Test
    fun `should not perform concurrent execution flow with nested launch`() = runTest {
        val expected = listOf(
            "Sledge: Suplex!",
            "Hammer: Clothesline!",
            "Sledge: Figure-four Leglock!",
            "Hammer: Piledriver!",
            "Sledge: Pinning 1-2-3!"
        )
        val actual = mutableListOf<String>()
        runBlocking {
            //like the 'runBlocking' the 'launch' also accepts a suspending lambda as an argument
            //running a new coroutine without blocking the current thread
            //that means: firstly, the 'runBlocking' blocks the current thread and executes the operations
            //and then executes the 'launch'
            // launch() builder also creates a coroutine, and any code that comes after it will be
            // run immediately after the coroutine is launched.
            launch {
                actual.add("Hammer: Clothesline!")
                actual.add("Hammer: Piledriver!")
            }
            actual.add("Sledge: Suplex!")
            actual.add("Sledge: Figure-four Leglock!")
            actual.add("Sledge: Pinning 1-2-3!")
        }
        assertThat(actual).isNotEqualTo(expected)
    }

    @Test
    fun `should perform concurrent execution flow with nested launch and multiple suspension`() = runTest {
        val expected = listOf(
            "Sledge: Suplex!",
            "Hammer: Clothesline!",
            "Sledge: Figure-four Leglock!",
            "Hammer: Piledriver!",
            "Sledge: Pinning 1-2-3!"
        )
        val actual = mutableListOf<String>()

        printThread()
        runBlocking {
            printThread()
            launch {
                printThread()
                actual.add("Hammer: Clothesline!")
                //yield - is a suspension function, and each time we call it, the coroutine hits a suspension point.
                //in other words, the 'yield' gives a chance to another coroutine to run some of its code.
                yield()
                actual.add("Hammer: Piledriver!")
                yield()
                printThread()
            }
            printThread()
            actual.add("Sledge: Suplex!")
            yield()
            actual.add("Sledge: Figure-four Leglock!")
            yield()
            actual.add("Sledge: Pinning 1-2-3!")
            yield()
            printThread()
        }
        assertThat(actual).isEqualTo(expected)
        printThread()
    }

    @Test
    fun `should perform concurrent execution flow`() = runTest {
        val expected = listOf(
            "Sledge: Suplex!",
            "tagging out",
            "Hammer: Clothesline!",
            "tagging out",
            "Sledge: Figure-four Leglock!",
            "tagging out",
            "Hammer: Piledriver!",
            "tagging out",
            "Sledge: Pinning 1-2-3!"
        )
        val actual = mutableListOf<String>()
        printThread()
        runBlocking {
            printThread()
            launch {
                printThread()
                actual.add("Hammer: Clothesline!")
                tagOut(actual)
                actual.add("Hammer: Piledriver!")
                tagOut(actual)
                printThread()
            }
            printThread()
            actual.add("Sledge: Suplex!")
            tagOut(actual)
            actual.add("Sledge: Figure-four Leglock!")
            tagOut(actual)
            actual.add("Sledge: Pinning 1-2-3!")
            printThread()
        }
        assertThat(actual).isEqualTo(expected)
        printThread()
    }

    @Test
    fun `it challenges me to better understand this topic`() = runTest {
        val expected = listOf(
            "Sledge: Suplex!",
            "tagging out",
            "Hammer: Clothesline!",
            "Hammer: Piledriver!",
            "tagging out",
            "Sledge: Figure-four Leglock!",
            "tagging out",
            "Sledge: Pinning 1-2-3!"
        )
        val actual = mutableListOf<String>()
        printThread()
        runBlocking {
            printThread()
            launch {
                printThread()
                actual.add("Hammer: Clothesline!")
                actual.add("Hammer: Piledriver!")
                tagOut(actual)
                printThread()
            }
            printThread()
            actual.add("Sledge: Suplex!")
            tagOut(actual)
            actual.add("Sledge: Figure-four Leglock!")
            tagOut(actual)
            actual.add("Sledge: Pinning 1-2-3!")
            printThread()
        }
        assertThat(actual).isEqualTo(expected)
        printThread()
    }

    @Test
    fun `it challenges me to better understand this topic v2`() = runTest {
        val expected = listOf(
            "Sledge: Suplex!",
            "tagging out",
            "Sledge: Figure-four Leglock!",
            "tagging out",
            "Sledge: Pinning 1-2-3!",
            "tagging out",
            "Hammer: Clothesline!",
            "tagging out",
            "Hammer: Piledriver!",
        )
        val actual = mutableListOf<String>()

        printThread()

        runBlocking {
            printThread()

            actual.add("Sledge: Suplex!")
            tagOut(actual)
            actual.add("Sledge: Figure-four Leglock!")
            tagOut(actual)
            actual.add("Sledge: Pinning 1-2-3!")
            tagOut(actual)

            //runs new coroutine and blocks the current thread
            runBlocking {
                printThread()

                actual.add("Hammer: Clothesline!")
                tagOut(actual)
                actual.add("Hammer: Piledriver!")

                printThread()
            }
            printThread()
        }
        assertThat(actual).isEqualTo(expected)
        printThread()
    }

    //suspending or suspend function - has capability to suspending a coroutine
    //suspend as a term - Pause here, hand something to the caller, and remember where I was, so I can continue later.
    private suspend fun tagOut(tasks: MutableList<String>) {
        tasks.add("tagging out")
        yield()
    }

    private fun printThread() = println(Thread.currentThread().name)
}