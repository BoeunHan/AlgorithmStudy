package `0x10`


fun main() = with(System.`in`.bufferedReader()) {
    val array = IntArray(11)
    array[1] = 1
    array[2] = 2
    array[3] = 4

    for (i in 4..10) {
        array[i] = array[i - 1] + array[i - 2] + array[i - 3]
    }

    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        println(array[n])
    }
}