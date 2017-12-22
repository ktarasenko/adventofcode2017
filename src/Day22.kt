import kotlin.math.sqrt

object Day22 {

    fun solve(rounds: Int, list: List<String>): Int {
        val s = rounds
        val arr = Array(s, {Array(s, {false})})
        val f = s/2 - list.size/2
        for (i in 0 until list.size){
            for (j in 0 until list.size){
                arr[f+i][f+j] = list[i][j]=='#'
            }
        }
        var p = Point(s/2,s/2)
        var m = up
        var inf = 0
        repeat(rounds, {
            if (arr[p.first][p.second]){
                m = turnRight(m)
            } else {
                m = turnLeft(m)
                inf++
            }
            arr[p.first][p.second] = !arr[p.first][p.second]
            p = m(p)
        })

       // println(arr.joinToString("\n") { it.joinToString(""){if (it) "#" else "."} })
        return inf
    }

    fun solve2(rounds: Int, list: List<String>): Int {
        val s = sqrt(rounds.toDouble()).toInt()
        val arr = Array(s, {Array(s, {0.toByte()})})
        val f = s/2 - list.size/2
        for (i in 0 until list.size){
            for (j in 0 until list.size){
                arr[f+i][f+j] = if (list[i][j]=='#') 2 else 0
            }
        }
        var p = Point(s/2,s/2)
        var m = up
        var inf = 0
        repeat(rounds, {
            arr[p.first][p.second] = when (arr[p.first][p.second]){
                0.toByte() -> {m = turnLeft(m); 1}
                1.toByte() -> {inf++; 2}
                2.toByte() -> {m = turnRight(m); 3}
                else -> {m =turnLeft(m); m =turnLeft(m); 0}
            }
            p = m(p)
        })

       // println(arr.joinToString("\n") { it.joinToString(""){if (it) "#" else "."} })
        return inf
    }

    val up: Move = {p -> Point(p.first -1, p.second)}
    val down: Move = {p -> Point(p.first +1, p.second)}
    val left: Move = {p -> Point(p.first, p.second-1)}
    val right: Move = {p -> Point(p.first, p.second+1)}

    fun turnLeft(c : Move): Move = when(c){
        up -> left
        down -> right
        left -> down
        else -> up
    }

    fun turnRight(c : Move): Move = when(c){
        up -> right
        down -> left
        left -> up
        else -> down
    }

}

