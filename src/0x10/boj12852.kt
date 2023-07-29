package `0x10`


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(n + 1)
    val before = IntArray(n + 1)

    dp[1] = 0

    for (i in 2..n) {
        dp[i] = dp[i - 1]
        before[i] = i - 1
        if (i % 2 == 0) {
            if (dp[i / 2] < dp[i]) {
                dp[i] = dp[i / 2]
                before[i] = i / 2
            }
        }
        if (i % 3 == 0) {
            if (dp[i / 3] < dp[i]) {
                dp[i] = dp[i / 3]
                before[i] = i / 3
            }
        }
        dp[i] += 1
    }

    println(dp[n])
    print("$n ")

    var idx = n
    while (idx != 1) {
        print("${before[idx]} ")
        idx = before[idx]
    }
}