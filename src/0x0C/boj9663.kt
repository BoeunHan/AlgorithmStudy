package `0x0C`

private var n = 0
private var cnt = 0

private lateinit var isUsed1: BooleanArray
private lateinit var isUsed2: BooleanArray
private lateinit var isUsed3: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    isUsed1 = BooleanArray(n)
    isUsed2 = BooleanArray(2 * n - 1)
    isUsed3 = BooleanArray(2 * n - 1)

    func(0)
    println(cnt)
}

private fun func(k: Int) {
    if (k == n) {
        cnt++
        return
    }
    for (i in 0 until n) {
        if (!isUsed1[i] && !isUsed2[k + i] && !isUsed3[k - i + n - 1]) {
            isUsed1[i] = true
            isUsed2[k + i] = true
            isUsed3[k - i + n - 1] = true
            func(k + 1)
            isUsed1[i] = false
            isUsed2[k + i] = false
            isUsed3[k - i + n - 1] = false
        }
    }
}