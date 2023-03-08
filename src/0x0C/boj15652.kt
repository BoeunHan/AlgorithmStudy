package `0x0C`

private var n = 0
private var m = 0
private lateinit var array: IntArray
private val output = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val (_n, _m) = readLine().split(" ").map { it.toInt() }
    n = _n; m = _m

    array = IntArray(m)
    func(0)
    println(output)
}

private fun func(k: Int) {
    if (k == m) {
        for (i in array) output.append("$i ")
        output.append("\n")
        return
    }
    for (i in 1..n) {
        if (k == 0 || i >= array[k - 1]) {
            array[k] = i
            func(k + 1)
        }
    }
}