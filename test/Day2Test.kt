import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day2Test {

    @Test
    fun provided(){
        Assert.assertEquals(18, Day2.solve(("5 1 9 5\n" +
                "7 5 3\n" +
                "2 4 6 8").split("\n")))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(9, Day2.solve2(("5 9 2 8\n" +
                "9 4 7 3\n" +
                "3 8 6 5").split("\n")))
    }

    @Test
    fun test(){
        Assert.assertEquals(4, Day2.solve2(("1 2\n2 3 4 5").split("\n")))
    }

    @Test
    fun task(){
        Assert.assertEquals(43074, Day2.solve((File("input/day2.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(280, Day2.solve2((File("input/day2.txt").readLines())))
    }
}