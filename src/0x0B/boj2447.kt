package `0x0B`

private lateinit var stars: List<MutableList<Char>>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    stars = List(n) { MutableList(n) { ' ' } }
    star(0, 0, n)
    val output = StringBuilder()
    for (i in stars[0].indices) {
        for (j in stars.indices) {
            output.append(stars[i][j])
        }
        output.append("\n")
    }
    println(output)
}

private fun star(x: Int, y: Int, k: Int) {
    if (k == 1) {
        stars[x][y] = '*'
    } else {
        val k2 = k / 3
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (!(i == 1 && j == 1)) star(x + i * k2, y + j * k2, k2)
            }
        }
    }
}