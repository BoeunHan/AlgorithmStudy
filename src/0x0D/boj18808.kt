package `0x0D`

private var n = 0
private var m = 0
private var k = 0

private class Sticker(
    val r: Int,
    val c: Int,
    val sticker: Array<IntArray>
)

private lateinit var laptop: Array<IntArray>
private val stickers = ArrayList<Sticker>()

/*스티커 100개 * 행 10* 열 10 입력 = 10000
+스티커 100개* (4번*(회전 10*10 + n*m*10*10)+찾으면 10*10)) = 100*(4*(100+160000)+100) = 100*(640500) = 64000500
+최종 갯수 n*m = 1600
=64012100
*/
fun main() = with(System.`in`.bufferedReader()) {
    val (n1, m1, k1) = readLine().split(" ").map { it.toInt() }
    n = n1; m = m1; k = k1

    laptop = Array(n) { IntArray(m) { 0 } }

    repeat(k) {
        val (r1, c1) = readLine().split(" ").map { it.toInt() }
        val sticker = Array(r1) { readLine().split(" ").map { it.toInt() }.toIntArray() }
        stickers.add(Sticker(r1, c1, sticker))
    }

    for (sticker in stickers) {
        findArea(sticker)
    }

    println(countSticker())
}

private fun countSticker(): Int{
    var cnt = 0

    for(i in 0 until n){
        for(j in 0 until m){
            if (laptop[i][j] == 1) cnt++
        }
    }

    return cnt
}

private fun findArea(stk: Sticker) {
    var rotate_stk = stk

    for (i in 1..4) {
        if (stick(rotate_stk)) return
        rotate_stk = rotate(rotate_stk)
    }

    return
}

private fun rotate(stk: Sticker): Sticker {
    val new = Array(stk.c) { IntArray(stk.r) }
    for (i in 0 until stk.c) {
        for (j in 0 until stk.r) {
            new[i][j] = stk.sticker[stk.r - j - 1][i]
        }
    }
    return Sticker(stk.c, stk.r, new)
}

private fun stick(stk: Sticker): Boolean {
    var sticked = false
    label2@
    for (i in 0..(n - stk.r)) {
        for (j in 0..(m - stk.c)) {
            var pass = true
            label@
            for (k in 0 until stk.r) {
                for (l in 0 until stk.c) {
                    if (laptop[i + k][j + l] == 1 &&
                        stk.sticker[k][l] == 1
                    ) {
                        pass = false
                        break@label
                    }
                }
            }

            if (pass) {
                for (k in 0 until stk.r) {
                    for (l in 0 until stk.c) {
                        if (stk.sticker[k][l] == 1)
                            laptop[i + k][j + l] = stk.sticker[k][l]
                    }
                }
                sticked = true
                break@label2
            }
        }
    }

    return sticked
}


private fun printSticker(stk: Sticker) {
    for (i in 0 until stk.r) {
        for (j in 0 until stk.c) {
            print("${stk.sticker[i][j]} ")
        }
        println()
    }
}