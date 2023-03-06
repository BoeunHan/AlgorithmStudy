package `0x08`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()){
    val pipe = readLine()
    val stack = LinkedList<Char>()
    var cnt = 0
    var prev = ' '
    for(i in pipe){
        if(i == '(') stack.add(i)
        else if(prev == '('&& i == ')') {
            stack.removeLast()
            cnt += stack.size
        }
        else {stack.removeLast(); cnt++}
        prev = i
    }
    println(cnt)
}