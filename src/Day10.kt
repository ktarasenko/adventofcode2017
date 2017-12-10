import java.util.*

object Day10 {

    fun solve(size: Int, lengths: List<Int>): Int {
        val list = knotTie(size, lengths)
        return list[0] * list[1]
    }

    private fun knotTie(size: Int, lengths: List<Int>): List<Int> {
        val list = CircularList(0 until size)
        var p = 0
        lengths.forEachIndexed { skipSize, l ->
            list.subList(p, p + l).reverse()
            p += l + skipSize
        }
        return list.toNormalList()
    }

    fun solve2(lengths: String): String {
        val list = knotTie(256, (lengths.toCharArray().map { it.toInt() }
                + listOf(17, 31, 73, 47, 23)).repeat(64))
        return (0..15)
                .map { list.subList(it * 16, (it+1)* 16)}
                .map { it.xor()}
                .toHex()
    }


    class CircularList(values: Iterable<Int>) : ArrayList<Int>(values.toList()) {
        override fun get(index: Int): Int {
            return super.get(index % super.size)
        }

        override fun set(index: Int, element: Int): Int {
            return super.set(index % super.size, element)
        }

        override val size: Int
            get() = Int.MAX_VALUE

        override fun subList(fromIndex: Int, toIndex: Int): MutableList<Int> {
            return SubList(this, fromIndex, toIndex)
        }

        fun toNormalList(): MutableList<Int> = super.subList(0, super.size)

        class SubList(val parent: CircularList, val from: Int, val to: Int) : ArrayList<Int>() {

            override val size: Int
                get() = to - from

            override fun set(index: Int, element: Int): Int {
                return parent.set(from + index, element)
            }

            override fun get(index: Int): Int {
                return parent[from + index]
            }
        }
    }


    private fun <E> List<E>.repeat(times: Int): List<E> {
        val m = ArrayList<E>()
        m.ensureCapacity(this.size * times)
        repeat(times, {m.addAll(this)})
        return m
    }

}


fun List<Int>.toHex(): String =
        joinToString(separator = ""){it.toString(16).padStart(2, '0')}

fun List<Int>.xor(): Int = fold(0, {acc, i ->  acc.xor(i)})

