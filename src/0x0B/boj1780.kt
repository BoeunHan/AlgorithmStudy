package `0x0B`

private lateinit var paper: List<List<Int>>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    paper = List(n) { readLine().split(" ").map { it.toInt() } }

    val cnt = recur(0, 0, n)
    println(cnt.first)
    println(cnt.second)
    println(cnt.third)
}

private fun recur(x: Int, y: Int, k: Int): Triple<Int, Int, Int> {
    var cntMOne = 0
    var cntZero = 0
    var cntOne = 0
    if (k == 1) {
        return if (paper[x][y] == -1) Triple(1, 0, 0)
        else if (paper[x][y] == 0) Triple(0, 1, 0)
        else Triple(0, 0, 1)
    }
    println("x = $x, y = $y  k = $k")

    var sumMOne = 0
    var sumZero = 0
    var sumOne = 0
    val k2 = k / 3
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            val recur = recur(x + i * k2, y + j * k2, k2)
            sumMOne += recur.first
            sumZero += recur.second
            sumOne += recur.third
        }
    }
    println("sum: $sumMOne, $sumZero, $sumOne")
    if (sumMOne == 9) cntMOne++
    else if (sumZero == 9) cntZero++
    else if (sumOne == 9) cntOne++
    else {
        cntMOne += sumMOne
        cntZero += sumZero
        cntOne += sumOne
    }
    println("-일: $cntMOne, 영: $cntZero, 일: $cntOne")

    return Triple(cntMOne, cntZero, cntOne)
}