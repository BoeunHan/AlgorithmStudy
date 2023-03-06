package `0x08`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()){
    var cnt = 0
    repeat(readLine().toInt()){
        val str = readLine()
        val stack = LinkedList<Char>()
        var good = true
        for(i in str){
            if(stack.isEmpty()) stack.add(i)
            else if(stack.last == i) stack.removeLast()
            else stack.add(i)
        }
        if(stack.isNotEmpty()) good = false
        if(good) cnt++
    }
    println(cnt)
}