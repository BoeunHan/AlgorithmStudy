package `0x10`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val num = readLine().split(" ").map { it.toInt() }.toMutableList()
    val dp = MutableList(n) { 0 }
    dp[0] = 1

    for (i in 1 until n) {
        var idx = i
        var max = 0
        for (j in i - 1 downTo 0) {
            if (num[j] < num[i] && dp[j] > max) {
                max = dp[j]
                idx = j
            }
        }
        dp[i] = dp[idx] + 1
    }

    println(dp.maxOf { it })
}