object Day9 {

    fun solve(inp: String): Int {
        var score = 0
        var nested = 0
        var i = -1
        var garbage = false
        while (++i < inp.length){
            when (inp[i]){
                '{' -> if (!garbage) nested++
                '}' -> if (!garbage) score += nested--
                '<' -> garbage = true
                '>' -> garbage = false
                '!' -> i++
            }
        }
        return score
    }

    fun solve2(inp: String): Int {
        var i = -1
        var garbage = false
        var g = 0
        while (++i < inp.length){
            when (inp[i]){
                '<' -> if (garbage) g++ else garbage = true
                '>' -> garbage = false
                '!' -> i++
                else -> if (garbage) g++
            }
        }
        return g
    }

}
