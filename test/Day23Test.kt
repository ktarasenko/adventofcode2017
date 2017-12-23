import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day23Test {


    @Test
    fun task(){
        Assert.assertEquals(3025, Day23.solve((File("input/day23.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(915, Day23.solve2())
        Assert.assertEquals(915, Day23.solve(File("input/day23_mod.txt").readLines(), 1))
    }
}