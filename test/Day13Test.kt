import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day13Test {

    @Test
    fun provided(){
        Assert.assertEquals(24, Day13.solve(("0: 3\n" +
                "1: 2\n" +
                "4: 4\n" +
                "6: 4").split("\n")))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(10, Day13.solve2(("0: 3\n" +
                "1: 2\n" +
                "4: 4\n" +
                "6: 4").split("\n")))
    }

    @Test
    fun test(){
        Assert.assertEquals(12*4, Day13.solve(("12: 4").split("\n")))
        Assert.assertEquals(0, Day13.solve(("1: 2").split("\n")))
        Assert.assertEquals(8*2, Day13.solve(("8: 2").split("\n")))
        Assert.assertEquals(8*3, Day13.solve(("8: 3").split("\n")))
    }

    @Test
    fun task(){
        Assert.assertEquals(2264, Day13.solve((File("input/day13.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(3875838, Day13.solve2((File("input/day13.txt").readLines())))
    }
}