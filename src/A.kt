fun main() {
    val (r, x) = readln().split(" ").map { it.toInt() }

    val z = when (x) {
        1 -> r in 1600..2999
        2 -> r in 1200..2399
        else -> false
    }

    println(if (z) "Yes" else "No")
}