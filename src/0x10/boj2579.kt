package `0x10`

import java.lang.Integer.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val score = IntArray(n)
    val d = Array(2) { IntArray(n) }

    repeat(n) { score[it] = readLine().toInt() }

    if(n == 1) {
        println(score[0])
        return
    }

    d[0][0] = score[0]
    d[1][0] = 0
    d[0][1] = score[1]
    d[1][1] = score[0] + score[1]

    for(i in 2 until n){
        d[0][i] = max(d[0][i-2], d[1][i-2]) + score[i]
        d[1][i] = d[0][i-1] + score[i]
    }

    println(max(d[0][n-1], d[1][n-1]))

}