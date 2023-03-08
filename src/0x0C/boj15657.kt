package `0x0C`

private var n = 0
private var m = 0
private lateinit var array: IntArray
private lateinit var array2: List<Pair<Int, Int>>
private lateinit var myArray: Array<Pair<Int, Int>?>
private val output = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val (_n, _m) = readLine().split(" ").map { it.toInt() }
    n = _n; m = _m

    array = readLine().split(" ").map { it.toInt() }.toIntArray()
    array.sort()

    array2 = array.mapIndexed { index, i -> Pair(index, i) }
    myArray = Array(m) { null }

    func(0)
    println(output)
}

private fun func(k: Int) {
    if (k == m) {
        for (i in myArray) output.append("${i!!.second} ")
        output.append("\n")
        return
    }

    for (i in array2) {
        if (k == 0 || i.first > array2[k - 1].first) {
            myArray[k] = i
            func(k + 1)
        }
    }
}