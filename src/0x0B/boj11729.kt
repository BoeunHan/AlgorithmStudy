package `0x0B`


val s = StringBuilder()
var k = 0
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    hanoi(1, 3, n)
    println(k)
    print(s)
}

fun hanoi(a: Int, b: Int, n: Int) {
    if (n == 0) return
    hanoi(a, 6 - a - b, n - 1)
    s.append("$a $b\n")
    k++
    hanoi(6 - a - b, b, n - 1)
}