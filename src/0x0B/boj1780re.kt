package `0x0B`

private lateinit var paper: List<List<Int>>
private var cntMOne = 0
private var cntZero = 0
private var cntOne = 0
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    paper = List(n) { readLine().split(" ").map { it.toInt() } }

    splitPaper(0, 0, n)
    println(cntMOne)
    println(cntZero)
    println(cntOne)
}

private fun splitPaper(x: Int, y: Int, k: Int) {
    val pivot = paper[x][y]
    var split = false
    for (i in x until x + k) {
        for (j in y until y + k) {
            if (pivot != paper[i][j]) {
                split = true
                break
            }
        }
    }
    if (split) {
        val k2 = k / 3
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                splitPaper(x + i * k2, y + j * k2, k2)
            }
        }
    } else {
        when (pivot) {
            -1 -> cntMOne++
            0 -> cntZero++
            1 -> cntOne++
        }
    }
}