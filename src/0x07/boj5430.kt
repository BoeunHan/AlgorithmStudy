package `0x07`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()){
    loop@ for(i in 0 until readLine().toInt()){
        val p = readLine()
        val n = readLine().toInt()
        val tmpArr = readLine()
        val arr = tmpArr.substring(1..tmpArr.length - 2)
        val arr2 = if(arr == "") LinkedList()
        else LinkedList(arr.split(",").map{it.toInt()})

        var r = 0
        for(mode in p){
            when(mode){
                'R'->{
                    r++
                }
                'D'->{
                    if(arr2.isEmpty()) {
                        println("error")
                        continue@loop
                    }
                    else {
                        if(r%2 == 0) arr2.removeFirst()
                        else arr2.removeLast()
                    }
                }
            }
        }
        if(r%2 == 1) arr2.reverse()
        println("["+arr2.joinToString(",")+"]")
    }
}