import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day21Test {

    @Test
    fun provided(){
        Assert.assertEquals(12, Day21.solve(2, ("../.# => ##./#../...\n" +
                ".#./..#/### => #..#/..../..../#..#").split("\n")))
    }

    @Test
    fun task(){
        Assert.assertEquals(117, Day21.solve(5, (File("input/day21.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(2026963, Day21.solve(18, (File("input/day21.txt").readLines())))

    }
}