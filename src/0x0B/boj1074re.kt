package `0x0B`

import java.lang.Math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val (n, r, c) = readLine().split(" ").map { it.toInt() }

    println(recur(r, c, n))
}

private fun recur(r: Int, c: Int, k: Int): Int {
    if (k == 0) return 0
    val half = 2.pow(k - 1)
    return if (r < half && c < half) recur(r, c, k - 1)
    else if (r < half && c >= half) half * half + recur(r, c - half, k - 1)
    else if (r >= half && c < half) 2 * half * half + recur(r - half, c, k - 1)
    else 3 * half * half + recur(r - half, c - half, k - 1)
}

fun Int.pow(x: Int): Int {
    return pow(this.toDouble(), x.toDouble()).toInt()
}
