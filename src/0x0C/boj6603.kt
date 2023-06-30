package `0x0C`

private val myArray = Array(6) { 0 }
private val isUsed = BooleanArray(50)
private lateinit var arr: List<Int>
fun main() = with(System.`in`.bufferedReader()) {
    var input = readLine()
    while (input != "0") {
        arr = input.split(" ").map { it.toInt() }
        func(0)
        println()
        input = readLine()
    }
}

private fun func(k: Int) {
    if (k == 6) {
        for (i in myArray) print("$i ")
        println()
        return
    }
    for (i in 1 until arr.size) {
        if (!isUsed[arr[i]] && (k == 0 || myArray[k - 1] < arr[i])) {
            isUsed[arr[i]] = true
            myArray[k] = arr[i]
            func(k + 1)
            isUsed[arr[i]] = false
        }
    }
}