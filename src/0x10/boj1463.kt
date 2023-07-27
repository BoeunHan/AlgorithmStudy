package `0x10`

import java.lang.Integer.min

private lateinit var array: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    array = IntArray(n + 1)

    array[1] = 0
    for (i in 2..n) {
        array[i] = array[i - 1] + 1
        if (i % 2 == 0) array[i] = min(array[i], array[i / 2] + 1)
        if (i % 3 == 0) array[i] = min(array[i], array[i / 3] + 1)

    }
    println(array[n])
}