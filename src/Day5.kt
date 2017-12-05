object Day5 {

    fun solve(list: Iterable<String>): Int {
        val instr =  list.map { it.toInt() }.toMutableList()
        var n = 0
        var i = 0
        while (i < instr.size){
            n++
            i += instr[i]++
        }
        return n
    }

    fun solve2(list: Iterable<String>): Int {
        val instr =  list.map { it.toInt() }.toMutableList()
        var n = 0
        var i = 0
        while (i < instr.size){
            n++
            i += instr[i].also {instr[i] += if (it >= 3) -1 else 1 }

        }
        return n
    }

}
