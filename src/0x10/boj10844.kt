package `0x10`

fun main() = with(System.`in`.bufferedReader()) {

    val arr = Array(100) { IntArray(10) { 0 } }
    for (i in 1..9) arr[0][i] = 1

    for (i in 1..99) {
        for (j in 0..9) {
            if (j != 9) arr[i][j] = (arr[i][j] + arr[i - 1][j + 1]) % 1000000000
            if (j != 0) arr[i][j] = (arr[i][j] + arr[i - 1][j - 1]) % 1000000000
        }
    }

    val n = readLine().toInt()

    for (i in 0..99) {
        println(arr[i].contentToString())
    }
    var sum = 0
    for (i in 0..9) {
        sum = (sum + arr[n - 1][i]) % 1000000000
    }
    println(sum)
}
