import java.util.*

fun main() {
    val (h, w) = readln().split(' ').map { it.toInt() }
    val grid = Array(h) { readln().toCharArray() }
    val l = Array(h) { IntArray(w) { -1 } }
    val b = Array(h) { IntArray(w) { -1 } }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)
    val asd = listOf('v', '^', '>', '<')
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (grid[i][j] == 'E') {
                l[i][j] = 0
                queue.add(Pair(i, j))
            }
        }
    }
    while (queue.isNotEmpty()) {
        val (x, y) = queue.remove()
        for (d in 0..3) {
            val nx = x + dx[d]
            val ny = y + dy[d]
            if (nx in 0 until h && ny in 0 until w) {
                if (grid[nx][ny] == '.' && l[nx][ny] == -1) {
                    l[nx][ny] = l[x][y] + 1
                    b[nx][ny] = d
                    queue.add(Pair(nx, ny))
                }
            }
        }
    }
    val r = Array(h) { CharArray(w) }
    for (i in 0 until h) {
        for (j in 0 until w) {
            when (grid[i][j]) {
                '#' -> r[i][j] = '#'
                'E' -> r[i][j] = 'E'
                '.' -> {
                    val dir = b[i][j]
                    r[i][j] = asd[dir]
                }
            }
        }
    }
    for (d in r) {
        println(d.concatToString())
    }
}
