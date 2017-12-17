import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day17Test {

    @Test
    fun provided(){
        Assert.assertEquals(638, Day17.solve(3, 2017))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(1226, Day17.solve2(3,2017))
    }


    @Test
    fun task(){
        Assert.assertEquals(42, Day17.solve(343, 2017))
    }

    @Test
    fun task2(){
        Assert.assertEquals(42,  Day17.solve2(343, 50*1000*1000))
    }
}