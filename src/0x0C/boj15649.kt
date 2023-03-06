package `0x0C`

private var n = 0
private var m = 0
private lateinit var array: IntArray
private lateinit var isUsed: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val (_n, _m) = readLine().split(" ").map { it.toInt() }
    n = _n
    m = _m

    array = IntArray(m)
    isUsed = BooleanArray(n + 1)

    func(0)
}

private fun func(k: Int) {
    if (k == m) {
        for (i in array) print("$i ")
        println()
        return
    }
    for (i in 1..n) {
        if (!isUsed[i]) {
            array[k] = i
            isUsed[i] = true
            func(k + 1)
            isUsed[i] = false
        }
    }
}