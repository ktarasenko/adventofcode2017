import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day6Test {

    @Test
    fun provided(){
        Assert.assertEquals(5, Day6.solve(("0 2 7 0").split("\\s".toRegex())))
    }

    @Test
    fun task(){
        Assert.assertEquals(3156, Day6.solve((File("input/day6.txt").readText().split("\\s".toRegex()))))
    }

    @Test
    fun task2(){
        Assert.assertEquals(1610, Day6.solve2((File("input/day6.txt").readText().split("\\s".toRegex()))))
    }
}