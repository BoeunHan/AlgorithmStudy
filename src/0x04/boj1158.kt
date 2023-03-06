package `0x04`

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ")
    val n = input[0].toInt()
    val k = input[1].toInt()

    val result = StringBuilder()
    result.append("<")

    val arr = Array(n + 1) { i -> i + 1 }
    arr[n] = 1
    var pos = 0

    repeat(n) {
        var prev = pos
        repeat(k) {
            prev = pos
            pos = arr[pos]
        }
        result.append("$pos, ")
        arr[prev] = arr[pos]
        arr[pos] = -1
        pos = prev
    }
    result.deleteAt(result.length - 1)
    result.deleteAt(result.length - 1)
    result.append(">")
    println(result)
}