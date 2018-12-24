package test

import org.junit.Assert.*
import org.junit.Test

import main.tailrec.iteration

class FunctionsKtTest internal constructor() {
    @Test
    fun fact() {

    }

    @Test
    fun gcd() {
    }

    @Test
    fun fib() {
    }

    @Test
    fun pow() {
    }

    @Test
    fun newton() {
    }

    @Test
    fun iteration() {
        val ans = iteration(
            { x -> x - ((x*x*x - 2.0) / (3.0*x*x)) },
            3.0
        )
        assertEquals(2.0, ans * ans * ans, 0.00001)
    }
}
