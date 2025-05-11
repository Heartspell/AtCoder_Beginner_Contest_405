fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val a = readln().split(' ').map { it.toInt() }
    val r = (1..m).toSet()
    for (trash in 0..n) {
        val x = a.subList(0, n - trash)
        if (!x.toSet().containsAll(r)) {
            println(trash)
            return
        }
    }
}