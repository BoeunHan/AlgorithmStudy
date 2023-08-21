package `0x10`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }

    val dp = List(n) { i ->
        MutableList(n) { j ->
            (i == j || arr[i] == arr[j])
        }
    }

    for (i in n - 2 downTo 0) {
        for (j in i + 2 until n) {
            dp[i][j] = arr[i] == arr[j] && dp[i + 1][j - 1]
        }
    }

    val str = StringBuilder()
    repeat(readLine().toInt()) {
        val (n1, n2) = readLine().split(" ").map { it.toInt() }
        str.append(if (dp[n1 - 1][n2 - 1]) "1" else "0")
        str.append("\n")
    }
    println(str)
}