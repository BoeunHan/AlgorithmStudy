package `0x0C`

import java.util.LinkedList

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
    val isUsed = LinkedList<Int>()
    for (i in array2) {
        if (!isUsed.contains(i.second)) {
            myArray[k] = i
            isUsed.add(i.second)
            func(k + 1)
        }
    }
    isUsed.clear()
}