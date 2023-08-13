package `0x10`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    if (n == 1) {
        println(1)
        return@with
    }
    if (n == 2) {
        println(3)
        return@with
    }

    val dp = MutableList(n + 1) { 0 }

    dp[1] = 1
    dp[2] = 3

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007
    }
    println(dp[n] % 10007)
}