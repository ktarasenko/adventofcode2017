object Day19 {

    fun solve(list: Iterable<String>): String {
        val grid = list.map { it.toCharArray().toTypedArray() }.toTypedArray()
        var p = 0 to list.first().indexOf('|')
        var move = down
        val letters = mutableListOf<Char>()
        var steps = 0
        while (true) {
            p = move(p); steps++
            val c = grid[p.first][p.second]
            when (c) {
                '+' -> move = changeDirection(grid, move, p)
                in 'A'..'Z' -> letters.add(c)
                ' ' -> {println(steps); return letters.joinToString("")}
            }
        }

    }

    fun changeDirection(list: Grid, dir: Move, p: Point): Move =
            when (dir) {
                down, up -> listOf(left, right)
                else -> listOf(down, up)
            }.map { it to it(p) }
                    .first { list.getOrNull(it.second.first)?.getOrNull(it.second.second)
                            .let { it == '|' || it == '-' || it in 'A'..'Z'} }.first


    val down: Move = { inp -> inp.first + 1 to inp.second }
    val up: Move = { inp -> inp.first - 1 to inp.second }
    val left: Move = { inp -> inp.first to inp.second - 1 }
    val right: Move = { inp -> inp.first to inp.second + 1 }

    fun solve2(list: Iterable<String>): Int {
        return 42
    }

}
typealias Point = Pair<Int, Int>
typealias Move = (Point) -> Point
typealias Grid = Array<Array<Char>>
