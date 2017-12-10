import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Day10Test {

    @Test
    fun provided(){
        Assert.assertEquals(12, Day10.solve(5, ("3,4,1,5".split(",").map { it.toInt() })))
    }

    @Test
    fun provided2(){
        Assert.assertEquals("a2582a3a0e66e6e86e3812dcb672a272", Day10.solve2(""))
        Assert.assertEquals("33efeb34ea91902bb2f59c9920caa6cd", Day10.solve2("AoC 2017"))
        Assert.assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", Day10.solve2("1,2,3"))
        Assert.assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", Day10.solve2("1,2,4"))
    }

    @Test
    fun test(){
        val l = Day10.CircularList(listOf(0, 1, 2, 3))
        assertEquals(3, l[3])
        assertEquals(0, l[4])
        assertEquals(1, l[9])
        assertEquals(1,l.subList(3, 7)[2])
        l.subList(3, 5).reverse()
        assertEquals(3, l[0])
        assertEquals(0, l[3])
        assertEquals(listOf(3, 1, 2, 0), l.toNormalList())
        assertEquals(64, "65 ^ 27 ^ 9 ^ 1 ^ 4 ^ 3 ^ 40 ^ 50 ^ 91 ^ 7 ^ 6 ^ 0 ^ 2 ^ 5 ^ 68 ^ 22".split(" ^ ").map { it.toInt() }
                .xor())
        assertEquals("4007ff", listOf(64, 7, 255).toHex())
    }


    @Test
    fun task(){
        Assert.assertEquals(11413, Day10.solve(256,
                (File("input/day10.txt").readText().split(",").map { it.toInt() })))
    }

    @Test
    fun task2(){
        Assert.assertEquals("7adfd64c2a03a4968cf708d1b7fd418d", Day10.solve2(File("input/day10.txt").readText()))
    }
}