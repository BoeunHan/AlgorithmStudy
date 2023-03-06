package `0x08`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    val stack = LinkedList<Any>()

    for (i in str) {
        if (i == '(' || i == '[') stack.add(i)
        else {
            if(stack.isEmpty()) {println(0); return}
            var out = stack.removeLast()
            var cnt = 0
            while (out is Int) {
                cnt += out
                if(stack.isEmpty()) {println(0); return}
                out = stack.removeLast()
            }
            if(cnt == 0) cnt = 1
            if(isPair(out as Char, i)) stack.add(cnt*getValue(i))
            else {println(0); return}
        }
    }
    var sum = 0
    for(i in stack){
        if(i is Int) sum += i
        else {println(0); return}
    }
    println(sum)
}

fun getValue(ch: Char): Int {
    return if (ch == ']') 3 else 2
}
private fun isPair(ch1: Char, ch2: Char): Boolean{
    return (ch1 == '(' && ch2 == ')')||(ch1 == '[' && ch2 == ']')
}
