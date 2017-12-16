import java.util.*

object Day16 {

    fun solve(inp: String, moves: Iterable<String>): String {
        return moves.fold(inp, { acc, s ->
            val op = s[0]
            val p = s.drop(1).split("/")
            when (op) {
                's' -> acc.takeLast(p[0].toInt()) + acc.dropLast(p[0].toInt())
                'x' -> acc.swap(p[0].toInt(), p[1].toInt())
                else -> acc.swap(acc.indexOf(p[0]), acc.indexOf(p[1]))
            }
        })
    }

    fun solve2(inp: String, times: Int, moves: Iterable<String>): String {
        var i = 0
        val l = LinkedHashSet<String>()
        l.add(inp)
        while (times > i++){
            if (!l.add(solve(l.last(), moves))){
                return l.drop(times % i).first()
            }
        }
        return l.last()
    }


}

private fun String.swap(p1: Int, p2: Int): String {
    val c = this.toCharArray()
    val t = c[p2]
    c[p2] = c[p1]
    c[p1] = t
    return c.joinToString(separator = "")
}
