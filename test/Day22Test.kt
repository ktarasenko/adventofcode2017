import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day22Test {

    @Test
    fun provided(){
        val list = ("..#\n" + "#..\n" + "...").split("\n")

        Assert.assertEquals(5, Day22.solve(7, list))

        Assert.assertEquals(41, Day22.solve(70, list))

        Assert.assertEquals(5587, Day22.solve(10000, list))
    }

    @Test
    fun provided2(){
        val list = ("..#\n" + "#..\n" + "...").split("\n")

        Assert.assertEquals(26, Day22.solve2(100, list))

        Assert.assertEquals(2511944, Day22.solve2(10000000, list))

    }


    @Test
    fun task(){
        Assert.assertEquals(5246, Day22.solve(10000, (File("input/day22.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(2512059, Day22.solve2(10000000, (File("input/day22.txt").readLines())))
    }
}