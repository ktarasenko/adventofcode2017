import java.util.*
import kotlin.coroutines.experimental.buildIterator

object Day3 {

    fun solve(n: Int): Int {
        if (n == 1) return 0

        val ringNumber = Math.ceil(Math.sqrt(n.toDouble())).toInt() / 2 + 1
        val startOfRing = ((ringNumber - 1) * 2 - 1).run { this * this }
        val posInRing = n - startOfRing
        val rowSize = (ringNumber - 1) * 2
        val posInRow = posInRing % rowSize
        val distanceToCenterOfRow = Math.abs(rowSize / 2 - posInRow)

        return ringNumber - 1 + distanceToCenterOfRow
    }

    fun solve2(n: Int): Int {
        val s = 20
        val arr = Array(s, { Array(s, { 0 }) })
        arr[s / 2][s / 2] = 1
        for (ringNumber in 2..s / 2) {
            var pos = arr.size / 2 + ringNumber - 1 to arr.size / 2 + ringNumber - 1
            val rowSize = (ringNumber - 1) * 2
            val operations = buildIterator {
                yieldAll(Collections.nCopies(rowSize, ::up))
                yieldAll(Collections.nCopies(rowSize, ::left))
                yieldAll(Collections.nCopies(rowSize, ::down))
                yieldAll(Collections.nCopies(rowSize, ::right))
            }
            operations.forEach {
                pos = it(pos)
                val next =  sumOfNeighbours(arr, pos)
                if (next > n){
                    return next
                }
                arr[pos.first][pos.second] = next
            }

        }
        return -1
    }

    private fun sumOfNeighbours(arr: Array<Array<Int>>, pos: Pair<Int, Int>): Int =
            arr[pos.first + 1][pos.second] +
                    arr[pos.first + 1][pos.second + 1] +
                    arr[pos.first + 1][pos.second - 1] +
                    arr[pos.first][pos.second + 1] +
                    arr[pos.first][pos.second - 1] +
                    arr[pos.first -1 ][pos.second] +
                    arr[pos.first - 1][pos.second + 1] +
                    arr[pos.first - 1][pos.second - 1]




    private fun up(pos: Pair<Int, Int>) = pos.first - 1 to pos.second
    private fun down(pos: Pair<Int, Int>) = pos.first + 1 to pos.second
    private fun left(pos: Pair<Int, Int>) = pos.first to pos.second - 1
    private fun right(pos: Pair<Int, Int>) = pos.first to pos.second + 1

}
