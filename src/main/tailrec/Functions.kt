package main.tailrec

import java.math.BigInteger
import kotlin.math.abs

tailrec fun fact(n: BigInteger, ans: BigInteger = BigInteger.ONE): BigInteger {
    if(n.compareTo(BigInteger.ONE) < 1) return ans
    return fact(n.dec(), ans * n)
}

tailrec fun gcd(a: Int, b: Int): Int{
    if(b == 0) return a
    return gcd(b, a%b)
}

tailrec fun fib(n: BigInteger, a: BigInteger = BigInteger.ZERO, b: BigInteger = BigInteger.ONE): BigInteger{
    if(n == BigInteger.ONE) return a
    return fib(n.dec(), b, a+b)
}

tailrec fun pow(a: BigInteger, n: Int, ans: BigInteger = BigInteger.ONE): BigInteger{
    if(n == 0) return ans
    return pow(a * a,  n.ushr(1),  if(n.and(1) == 1) ans * a else ans)
}

tailrec fun newton(
    f: (Double)-> Double,
    df: (Double)-> Double,
    x: Double,
    eps: Double = Float.MIN_VALUE.toDouble()
): Double {
    val xnew = x - f(x) / df(x)
    if(abs(xnew - x) < eps) return xnew
    return newton(f, df, xnew, eps)
}

tailrec fun iteration(
    r: (Double)-> Double,
    x: Double,
    eps: Double = Float.MIN_VALUE.toDouble()
): Double {
    val xnew = r(x)
    if(abs(xnew - x) < eps) return xnew
    return iteration(r, xnew, eps)
}

tailrec fun radixSort(list: List<UInt>, mask: UInt = 1u): List<UInt> {
    if (mask == 0u) return list
    val small = ArrayList<UInt>()
    val big = ArrayList<UInt>()
    list.forEach {
        if(it and mask == 0u) small.add(it) else big.add(it)
    }
    small.addAll(big)
    return radixSort(small, mask.shl(1))
}
