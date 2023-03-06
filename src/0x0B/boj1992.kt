package `0x0B`

lateinit var photo: List<List<Int>>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    photo = List(n) { readLine().toList().map { it - '0' } }
    println(compress(0, 0, n))
}

fun compress(x: Int, y: Int, k: Int): String {
    val pivot = photo[x][y]
    var split = false
    for (i in x until x + k) {
        for (j in y until y + k) {
            if (pivot != photo[i][j]) {
                split = true
                break
            }
        }
    }
    return if (split) {
        val k2 = k / 2
        var str = "("
        for (i in 0 until 2) {
            for (j in 0 until 2) {
                str += compress(x + i * k2, y + j * k2, k2)
            }
        }
        str += ")"
        return str
    } else pivot.toString()
}