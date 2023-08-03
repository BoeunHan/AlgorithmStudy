package `0x10`

private val fibo = Array(41) { Array(2) { 0 } }
fun main() = with(System.`in`.bufferedReader()) {
    fibo[0][0] = 1
    fibo[0][1] = 0
    fibo[1][0] = 0
    fibo[1][1] = 1

    for (i in 2..40) {
        fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0]
        fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1]
    }

    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        println("${fibo[n][0]} ${fibo[n][1]}")
    }
}

