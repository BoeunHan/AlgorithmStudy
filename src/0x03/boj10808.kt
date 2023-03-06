package `0x03`

fun main() = with(System.`in`.bufferedReader()){
    val str = readLine().toCharArray()
    val alphabet = IntArray(26){0}

    for(i in str.indices){
        alphabet[str[i] - 'a']++
    }
    for(i in alphabet.indices){
        print("${alphabet[i]} ")
    }

}