package `0x10`

import java.lang.Integer.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val score = IntArray(n)
    val d = IntArray(n)

    repeat(n) { score[it] = readLine().toInt() }

    d[0] = score[0]
    if (n > 1) d[1] = score[0] + score[1]
    if (n > 2) d[2] = max(score[0], score[1]) + score[2]

    for (i in 3 until n) {
        d[i] = score[i] + max(score[i-1]+d[i-3], d[i-2])
    }
    println(d[n-1])
}