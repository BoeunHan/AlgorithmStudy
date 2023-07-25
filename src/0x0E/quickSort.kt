package `0x0E`

private val arr = arrayOf(6, -8, 1, 12, 8, 3, 7, -7)

fun main() {

    quickSort(0, 8)

    println(arr.contentToString())
}

private fun quickSort(st: Int, en: Int) {

    if (st + 1 >= en) return
    val pivot = arr[st]
    var l = st + 1
    var r = en - 1
    while (true) {
        while (l <= r && arr[l] <= pivot) l++
        while (l <= r && arr[r] > pivot) r--
        if (r < l) break
        val tmp = arr[l]
        arr[l] = arr[r]
        arr[r] = tmp
    }
    arr[st] = arr[r]
    arr[r] = pivot

    quickSort(st, r)
    quickSort(r + 1, en)
}