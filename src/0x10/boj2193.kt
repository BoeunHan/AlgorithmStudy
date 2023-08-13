package `0x10`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = List(2) { MutableList<Long>(n + 1) { 0 } }
    dp[0][1] = 0
    dp[1][1] = 1

    if (n == 1) {
        println(1)
        return@with
    }
    for (i in 2..n) {
        dp[0][i] = dp[0][i - 1] + dp[1][i - 1]
        dp[1][i] = dp[0][i - 1]
    }
    println(dp[0][n] + dp[1][n])
}