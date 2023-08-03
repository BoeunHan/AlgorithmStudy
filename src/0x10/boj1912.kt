package `0x10`

import java.lang.Integer.max

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val num = readLine().split(" ").map { it.toInt() }
    val maxSum = MutableList(n) { 0 }
    maxSum[0] = num[0]
    var max = maxSum[0]
    for (i in 1 until n) {
        if (maxSum[i - 1] < 0) maxSum[i] = num[i]
        else maxSum[i] = num[i] + maxSum[i - 1]
        max = max(max, maxSum[i])
    }
    println(max)
}