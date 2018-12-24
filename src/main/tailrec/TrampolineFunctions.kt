package main.tailrec

import arrow.free.Trampoline
import arrow.free.TrampolineF
import arrow.free.map
import arrow.free.runT

fun goldenRatio(n: Int): TrampolineF<Double> = when(n < 1){
    true -> Trampoline.done(1.0)
    else -> Trampoline.defer { goldenRatio(n-1) }.map{ 1.0 + (1/it) }
}

fun odd(n: Int): TrampolineF<Boolean> = when (n) {
    0 -> Trampoline.done(false)
    else ->  Trampoline.defer { even(n - 1) }
}
fun even(n: Int): TrampolineF<Boolean> = when (n) {
    0 -> Trampoline.done(true)
    else -> Trampoline.defer { odd(n - 1) }
}

fun mc(n: Int): TrampolineF<Int> = when(n > 100){
    true -> Trampoline.done(n - 10)
    else -> Trampoline.defer { mc(n + 11) }.map{ mc(it).runT() }
}

fun ack(m: Int, n: Int): TrampolineF<Int> {
    if (m == 0) return Trampoline.done(n + 1)
    if (n == 0) return Trampoline.defer { ack(m-1, 1) }
    return Trampoline.defer { ack(m, n-1) }.map{ ack(m-1, it).runT() }
}
