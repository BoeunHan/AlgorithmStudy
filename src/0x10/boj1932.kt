package `0x10`


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val tri = Array(n) { IntArray(it + 1) }
    val sum = Array(n) { IntArray(it + 1) }

    repeat(n) { i ->
        readLine().split(" ").forEachIndexed { j, value -> tri[i][j] = value.toInt() }
    }

    sum[0][0] = tri[0][0]

    for (i in 1 until n) {
        for (j in 0 until i + 1) {
            if (j - 1 < 0) sum[i][j] = sum[i - 1][j]
            else if (j >= i) sum[i][j] = sum[i - 1][j - 1]
            else if (sum[i - 1][j - 1] >= sum[i - 1][j]) sum[i][j] = sum[i - 1][j - 1]
            else sum[i][j] = sum[i - 1][j]

            sum[i][j] += tri[i][j]
        }
    }

    println(sum[n - 1].maxOf { it })
}