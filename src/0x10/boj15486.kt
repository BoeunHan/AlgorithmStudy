package `0x10`

import kotlin.math.max

private data class Consult2(
    val day: Int,
    val money: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val consult = ArrayList<Consult2>()
    repeat(n) {
        val (day, money) = readLine().split(" ").map { it.toInt() }
        consult.add(Consult2(day, money))
    }

    consult.reverse()

    val dp = List(2) { MutableList<Long>(n + 1) { 0 } }

    dp[0][0] = 0
    dp[1][0] = (if (consult[0].day > 1) 0 else consult[0].money).toLong()

    for (i in 1 until n) {
        if (i - consult[i].day + 1 < 0) dp[1][i] = max(dp[0][i - 1], dp[1][i - 1])
        else if (i - consult[i].day + 1 == 0) dp[1][i] = consult[i].money.toLong()
        else dp[1][i] = consult[i].money + max(dp[0][i - consult[i].day], dp[1][i - consult[i].day])

        dp[0][i] = max(dp[0][i - 1], dp[1][i - 1])

    }

    println(max(dp[0].maxOf { it },dp[1].maxOf { it }))
}