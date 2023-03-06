package `0x07`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()){
    val input = readLine().split(" ")
    val n = input[0].toInt()
    val queue = LinkedList<Int>()
    for(i in 1..n) queue.add(i)

    val arr = readLine().split(" ")
    var output = 0

    for(i in arr){
        val pos = queue.indexOf(i.toInt())
        if(pos == 0){
            queue.removeAt(0)
        }
        else{
            if(pos <= queue.size - pos){
                repeat(pos){
                    queue.addLast(queue.removeFirst())
                    output++
                }
            }
            else{
                repeat(queue.size - pos){
                    queue.addFirst(queue.removeLast())
                    output++
                }
            }
            queue.removeFirst()
        }
    }
    println(output)
}