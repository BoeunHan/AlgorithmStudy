package `0x0E`

private val arr = arrayOf(6, -8, 1, 12, 8, 3, 7, -7)
private val tmp = IntArray(8)

fun main() {

    mergeSort(0, 8)

    println(arr.contentToString())
}

private fun mergeSort(st: Int, en: Int) {
    if (st + 1 == en) return

    println(arr.contentToString())
    val mid = (st + en) / 2
    mergeSort(st, mid)
    mergeSort(mid, en)

    var lIdx = st
    var rIdx = mid

    for (i in st until en) {
        if (rIdx == en) tmp[i] = arr[lIdx++]
        else if (lIdx == mid) tmp[i] = arr[rIdx++]
        else if (arr[lIdx] <= arr[rIdx]) tmp[i] = arr[lIdx++]
        else tmp[i] = arr[rIdx++]
    }

    for (i in st until en) arr[i] = tmp[i]

}