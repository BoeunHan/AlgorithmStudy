package `0x0B`

import java.lang.StringBuilder

var n = 0
fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.")
    recur(0)
}

private fun recur(k: Int) {
    println("${count(k)}\"재귀함수가 뭔가요?\"")
    if (k == n) {
        println("${count(k)}\"재귀함수는 자기 자신을 호출하는 함수라네\"")
    } else {
        println("${count(k)}\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.")
        println("${count(k)}마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.")
        println("${count(k)}그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"")
        recur(k + 1)
    }
    println("${count(k)}라고 답변하였지.")
}

fun count(k: Int): String {
    val str = StringBuilder()
    for (i in 0 until k) str.append("____")
    return str.toString()
}