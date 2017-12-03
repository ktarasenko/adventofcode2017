import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day3Test {

    @Test
    fun provided(){
        Assert.assertEquals(0, Day3.solve(1))
        Assert.assertEquals(3, Day3.solve(12))
        Assert.assertEquals(2, Day3.solve(23))
        Assert.assertEquals(31, Day3.solve(1024))
    }




    @Test
    fun task(){
        Assert.assertEquals(430, Day3.solve(312051))
    }

    @Test
    @Ignore
    fun task2(){
        Assert.assertEquals(312453, Day3.solve2(312051))
    }
}