object Day6 {

    fun solve(list: List<String>): Int {
        val seenBefore = mutableSetOf<String>()
        var blocks = list.map { it.toInt() }
        var n = 0
        while (seenBefore.add(blocks.toString())) {
            blocks = redistribute(blocks)
            n++
        }
        return n
    }

    fun solve2(list: List<String>): Int {
        val seenBefore = mutableSetOf<String>()
        var blocks = list.map { it.toInt() }
        var n = 0
        var stateToRepeat: String? = null
        while (true) {
            blocks = redistribute(blocks)
            n++
            val currState = blocks.toString()
            if (stateToRepeat == null) {
                if (!seenBefore.add(currState)) {
                    stateToRepeat = currState
                    n = 0
                }
            } else {
                if (stateToRepeat == currState) {
                    break
                }
            }
        }
        return n
    }

    private fun redistribute(blocks: List<Int>): List<Int> {
        val (pos,amount) = blocks.mapIndexed { i, e -> i to e }.maxBy { it.second }!!
        val count = blocks.size
        return blocks.mapIndexed { i, e ->
            val fullRounds = amount / count
            val lastRound = if (( i- pos + count) % count in 1..(amount % count)) 1 else 0
            val base = if (pos != i) e else 0
            base + fullRounds + lastRound
        }
    }


}
