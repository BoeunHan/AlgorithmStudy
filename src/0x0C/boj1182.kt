package `0x0C`

private lateinit var array: IntArray
private var n = 0
private var s = 0
private var cnt = 0
fun main() = with(System.`in`.bufferedReader()) {
    val (_n, _s) = readLine().split(" ").map { it.toInt() }
    n = _n
    s = _s
    array = readLine().split(" ").map { it.toInt() }.toIntArray()

    func(0, 0)
    if(s == 0) cnt--
    println(cnt)
}

private fun func(k: Int, sum: Int) {
    if (k == n) {
        if (sum == s) cnt++
        return
    }
    func(k + 1, sum)
    func(k + 1, sum + array[k])
}