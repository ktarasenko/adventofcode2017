import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day11Test {

    @Test
    fun provided(){
        Assert.assertEquals(3, Day11.solve(("ne,ne,ne").split(",")))
        Assert.assertEquals(3, Day11.solve(("nw,nw,nw").split(",")))
        Assert.assertEquals(3, Day11.solve(("se,se,se").split(",")))
        Assert.assertEquals(0, Day11.solve(("ne,ne,sw,sw").split(",")))
        Assert.assertEquals(2, Day11.solve(("ne,ne,s,s").split(",")))
        Assert.assertEquals(3, Day11.solve(("se,sw,se,sw,sw").split(",")))
    }

    @Test
    @Ignore
    fun provided2(){
        Assert.assertEquals(42, Day11.solve2(("a\nb").split("\n")))
    }

    @Test
    @Ignore
    fun test(){
        Assert.assertEquals(42, Day11.solve(("a\nb").split("\n")))
    }

    @Test
    fun task(){
        Assert.assertEquals(42, Day11.solve((File("input/day11.txt").readText().split(","))))
    }

    @Test
    @Ignore
    fun task2(){
        Assert.assertEquals(42, Day11.solve2((File("input/day11.txt").readText().split(","))))
    }
}