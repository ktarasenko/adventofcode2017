import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day5Test {

    @Test
    fun provided(){
        Assert.assertEquals(5, Day5.solve(("0\n" +
                "3\n" +
                "0\n" +
                "1\n" +
                "-3").split("\n")))
    }


    @Test
    fun provided2(){
        Assert.assertEquals(10, Day5.solve2(("0\n" +
                "3\n" +
                "0\n" +
                "1\n" +
                "-3").split("\n")))
    }


    @Test
    fun task(){
        Assert.assertEquals(360603, Day5.solve((File("input/day5.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(25347697, Day5.solve2((File("input/day5.txt").readLines())))
    }
}