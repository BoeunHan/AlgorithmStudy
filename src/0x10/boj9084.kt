package `0x10`

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val coinCnt = readLine().toInt()
        val coins = readLine().split(" ").map { it.toInt() }
        val n = readLine().toInt()

        val dp = List(coinCnt) { MutableList(n + 1) { 0 } }
        for (i in 0 until coinCnt) dp[0][i] = 0

        for (i in 1..n) {
            for (j in 0 until coinCnt) {
                val coin = coins[j]

                if (i == coin) dp[j][i] = 1
                else if (i < coin) dp[j][i] = 0
                else {
                    var sum = 0
                    for (k in 0..j) sum += dp[k][i - coin]
                    dp[j][i] = sum
                }
            }
        }
        var sum = 0
        for (i in 0 until coinCnt) {
            sum += dp[i][n]
        }
        println(sum)
    }
}