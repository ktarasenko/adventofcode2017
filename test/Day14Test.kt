import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day14Test {

    @Test
    fun provided(){
        Assert.assertEquals(8108, Day14.solve(("flqrgnkx")))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(1242, Day14.solve2(("flqrgnkx")))
    }

    @Test
    fun test(){
        print(knotHash("flqrgnkx-0").take(2).toInt(16).toString(2))
    }

    @Test
    fun task(){
        Assert.assertEquals(8214, Day14.solve((File("input/day14.txt").readText())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(1093, Day14.solve2((File("input/day14.txt").readText())))
    }
}