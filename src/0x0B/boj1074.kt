package `0x0B`

var cnt = 0
fun main() = with(System.`in`.bufferedReader()) {
    val (n, r, c) = readLine().split(" ").map { it.toInt() }

    recur(0, 0, r, c, n)
}

fun recur(x: Int, y: Int, r: Int, c: Int, k: Int) {
    if (x == r && y == c) {
        println(cnt); return
    }
    if (k == 0) {
        cnt++; return
    }
    recur(x, y, r, c, k - 1)
    recur(x, y + 2.pow(k - 1), r, c, k - 1)
    recur(x + 2.pow(k - 1), y, r, c, k - 1)
    recur(x + 2.pow(k - 1), y + 2.pow(k - 1), r, c, k - 1)
}

