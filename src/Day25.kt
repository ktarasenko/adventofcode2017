object Day25 {



    fun solve(rep: Int, inp: List<String>): Int {
        var states = parseInput(inp)
        val a = Array(rep, {0})
        var i = rep / 2
        var state = "A"
        repeat(rep, {
            val p = states.getValue(state).let {
                if (a[i] == 0) {
                    it.first
                } else {
                    it.second
                }
            }
            p(a, i).also {
                state = it.first
                i = it.second
            }

        })
        return a.count{ it == 1}
    }

    private fun parseInput(inp: List<String>): Map<String, Pair<StateAction, StateAction>> =
            inp.map {
                val (name, a, b) = it.split("|")
                name to (parseAction(a) to parseAction(b))
            }.toMap()

    private fun parseAction(action: String): StateAction = {arr, i->
        val (v, m, s) = action.split(" ")
        arr[i] = v.toInt()
        s to i+m.toInt()
    }

    fun solve2(list: Iterable<String>): Int {
        return 42
    }

}

typealias StateAction = (Array<Int>, Int) -> Pair<String, Int>
