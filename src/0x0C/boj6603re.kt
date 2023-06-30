package `0x0C`

private val myArray = Array(6) { 0 }
private lateinit var arr: List<Int>
fun main() = with(System.`in`.bufferedReader()) {
    var input = readLine()
    while (input != "0") {
        arr = input.split(" ").map { it.toInt() }
        func(0, 0)
        println()
        input = readLine()
    }
}

private fun func(k: Int, last: Int) {
    if (k == 6) {
        for (i in myArray) print("$i ")
        println()
        return
    }
    for (i in last + 1 until arr.size) {
        myArray[k] = arr[i]
        func(k + 1, i)
    }
}