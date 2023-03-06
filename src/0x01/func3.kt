package `0x01`

import kotlin.math.sqrt

fun myFunc3(n: Int): Int{
    val rem = sqrt(n.toDouble()).rem(1)
    return if(rem == 0.0) 1 else 0
}

fun func3(n: Int): Int{
    for(i in 1..sqrt(n.toDouble()).toInt()){
        if(i*i == n) return 1
    }
    return 0
}
//O(루트n)

fun main(){
    println(myFunc3(9))
    println(myFunc3(18))
    println(myFunc3(81))
    println(myFunc3(693953651))
    println(myFunc3(756580036))

    println(func3(9))
    println(func3(18))
    println(func3(81))
    println(func3(693953651))
    println(func3(756580036))
}