package main.no_tailrec

import java.math.BigInteger

fun fact(n: BigInteger): BigInteger{
    var i = n
    var ans = BigInteger.ONE
    generateSequence { (i--).takeIf { i > BigInteger.ZERO } }.forEach {
        ans *= it
    }
    return ans
}

fun gcd(a: Int, b: Int): Int{
    var x = a
    var y = b
    var temp: Int
    while (y != 0){
        temp = y
        y = x % y
        x = temp
    }
    return x
}

/*fun fib(n: BigInteger): BigInteger{
    val fibo =
            generateSequence(BigInteger.ZERO to BigInteger.ONE) { (a, b) -> b to (a + b) }
                .map { it.first }
                .


    var x = BigInteger.ZERO
    var y = BigInteger.ONE

    val range = BigInteger.ONE.rangeTo(java.math.BigInteger.TEN)

}*/