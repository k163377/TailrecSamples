package test

import arrow.free.runT
import main.tailrec.*
import org.junit.Assert.*
import org.junit.Test

class TrampolineFunctionsKtTest {
    @Test
    fun testGoldenRatio() {
        assertEquals(
            1.618,
            goldenRatio(100000).runT(),
            0.0001
        )
    }

    @Test
    fun testOdd() {
        assertTrue(!odd(10000).runT())
        assertTrue(odd(10001).runT())
    }

    @Test
    fun testEven() {
        assertTrue(even(10000).runT())
        assertTrue(!even(10001).runT())
    }
}
