package `0x10`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val num = readLine().split(" ").map { it.toInt() }.toMutableList()
    val dp = MutableList(n) { 0 }

    dp[0] = num[0]
    for (i in 1 until n) {
        var idx = i
        var max = 0
        for (j in i - 1 downTo 0) {
            if (num[j] < num[i] && dp[j] > max) {
                idx = j
                max = dp[j]
            }
        }
        dp[i] = num[i] + dp[idx]
    }
    println(dp.maxOf { it })
}