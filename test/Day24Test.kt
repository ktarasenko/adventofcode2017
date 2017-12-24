import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day24Test {

    @Test
    fun provided(){
        Assert.assertEquals(31, Day24.solve(("0/2\n" +
                "2/2\n" +
                "2/3\n" +
                "3/4\n" +
                "3/5\n" +
                "0/1\n" +
                "10/1\n" +
                "9/10").split("\n")))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(19, Day24.solve2(("0/2\n" +
                "2/2\n" +
                "2/3\n" +
                "3/4\n" +
                "3/5\n" +
                "0/1\n" +
                "10/1\n" +
                "9/10").split("\n")))
    }


    @Test
    fun task(){
        Assert.assertEquals(2006, Day24.solve((File("input/day24.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(1994, Day24.solve2((File("input/day24.txt").readLines())))
    }
}