import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day15Test {

    @Test
    fun provided(){
        Assert.assertEquals(588, Day15.solve(65,8921))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(309, Day15.solve2(65,8921))
    }

    @Test
    fun task(){
        Assert.assertEquals(567, Day15.solve(512, 191))
    }

    @Test
    fun task2(){
        Assert.assertEquals(323, Day15.solve2(512, 191))
    }
}