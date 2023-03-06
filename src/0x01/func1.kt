package `0x01`

fun myFunc1(n: Int): Int {
    var sum = 0
    for(i in 1..n){
        if(i%3==0 || i%5==0) sum+=i
    }
    return sum
}

fun main(){
    println(myFunc1(16))
    println(myFunc1(34567))
    println(myFunc1(27639))
}