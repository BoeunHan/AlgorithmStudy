package `0x06`

fun main() = with(System.`in`.bufferedReader()) {
    val arr = IntArray(2000000)
    var head = 0
    var tail = 0
    val output = StringBuilder()
    repeat(readLine().toInt()) {
        val input = readLine().split(" ")
        when (input[0]) {
            "push" -> {
                arr[tail++] = input[1].toInt()
            }
            "pop" -> {
                if (head == tail) output.append("-1\n")
                else output.append("${arr[head++]}\n")
            }
            "size" -> {
                output.append("${tail - head}\n")
            }
            "empty" -> {
                output.append("${if (head == tail) 1 else 0}\n")
            }
            "front" -> {
                output.append("${if (head == tail) -1 else arr[head]}\n")
            }
            "back" -> {
                output.append("${if (head == tail) -1 else arr[tail - 1]}\n")
            }
        }
    }
    println(output)
}
