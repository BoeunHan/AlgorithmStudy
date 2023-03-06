package `0x08`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()){
    var str = readLine()

    while(str != "."){
        val newStr = onlyBracket(str)
        val stack = LinkedList<Char>()

        var balance = true
        for(i in newStr){
            if(i == '(' || i == '[') stack.add(i)
            else{
                if(stack.isEmpty()) {balance = false; break}
                else if(isPair(stack.last, i)) stack.removeLast()
                else {balance = false; break}
            }
        }
        if(stack.isNotEmpty()) balance = false

        println(if(balance) "yes" else "no")
        str = readLine()
    }
}

fun onlyBracket(str: String): String{
    var newStr = ""
    for(i in str){
        if(i == '(' || i == ')' || i == '[' || i == ']') newStr += i.toString()
    }
    return newStr
}
private fun isPair(ch1: Char, ch2: Char): Boolean{
    return (ch1 == '(' && ch2 == ')')||(ch1 == '[' && ch2 == ']')
}