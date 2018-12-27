package main.no_tailrec

import java.math.BigInteger
import kotlin.math.abs

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

fun fib(n: BigInteger): BigInteger{
    var i = n
    var a = BigInteger.ZERO
    var b = BigInteger.ONE
    var temp: BigInteger
    while (i > BigInteger.ONE){
        temp = b
        b = a + b
        a = temp
        i--
    }
    return a
}

fun pow(a: BigInteger, n: Int): BigInteger{
    var i = n
    var atemp = a
    var ans = BigInteger.ONE
    while (i != 0){
        if(i.and(1) == 1) ans *= atemp
        atemp *= atemp
        i = i.ushr(1)
    }
    return ans
}

fun newton(
    f: (Double)-> Double,
    df: (Double)-> Double,
    x0: Double,
    eps: Double = Float.MIN_VALUE.toDouble()
): Double{
    var x: Double
    var xnew: Double = x0
    do {
        x = xnew
        xnew = x - f(x)/df(x)
    }while (abs(x - xnew) > eps)
    return xnew
}

fun goldenRatio(n: Int): Double{
    var ans = 1.0
    for(i in 0 .. n){
        ans = 1.0 + 1.0 / ans
    }
    return ans
}