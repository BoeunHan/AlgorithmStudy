package `0x10`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(n + 1)


    dp[1] = 1
    if (n > 1) dp[2] = 2

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
    }

    println(dp[n] % 10007)
}