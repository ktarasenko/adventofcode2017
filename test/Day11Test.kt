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
    fun task(){
        Assert.assertEquals(720, Day11.solve((File("input/day11.txt").readText().split(","))))
    }

}