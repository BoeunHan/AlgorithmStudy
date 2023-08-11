package `0x10`

fun main() = with(System.`in`.bufferedReader()) {

    val arr = LongArray(101) { 0 }
    arr[1] = 1
    arr[2] = 1
    arr[3] = 1
    arr[4] = 2
    for (i in 5..100) {
        arr[i] = arr[i - 1] + arr[i - 5]
    }

    repeat(readLine().toInt()) {
        println(arr[readLine().toInt()])
    }
}