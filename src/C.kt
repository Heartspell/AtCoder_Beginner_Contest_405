fun main() {
    val n = readln().toInt()
    val a = readln().split(' ').map { it.toLong() }

    var x = a.sum()
    var r = 0L

    for (i in 0..<n - 1) {
        x -= a[i]
        r += a[i] * x
    }
    println(r)
}