import java.util.*

object Day17 {

    fun solve(diff: Int, steps: Int): Int {
        val buff = mutableListOf(0)
        var s = 0
        (1..steps).forEach{
            s = (s + diff) % buff.size + 1
            buff.add(s, it)
        }
        return buff[s+1]
    }

    fun solve2(diff: Int, steps: Int): Int {
        var s = 0
        var v = 0
        (1..steps).forEach{
            s = (s + diff) % it + 1
            if(s == 1){
                v = it
            }
        }
        return v
    }

}
