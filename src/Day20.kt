import kotlin.math.abs

object Day20 {

    fun solve(list: Iterable<String>): Int {
//        p=<662,-1337,-2423>, v=<91,-190,-339>, a=<-6,11,20>
        val ps = parseInput(list)
        var m = -1
        var mk = 0
        for (i in 0..Int.MAX_VALUE){
            val min = ps.mapIndexed {index, particle -> index to particle.d(i) }
                    .minBy { it.second }!!.first
            if(min == m){
                mk++
            } else {
                m = min
                mk = 0
            }
            if (mk == 1000){
                return m
            }
        }
        return -1
    }

    private fun parseInput(list: Iterable<String>): List<Particle> {
        val ps = list.map {
            val p = parseCoords(it, it.indexOf("p="))
            val v = parseCoords(it, it.indexOf("v="))
            val a = parseCoords(it, it.indexOf("a="))
            Particle(p, v, a)
        }
        return ps
    }

    private fun parseCoords(it: String, start: Int): Coords {
        val (x, y, z) = it.substring(it.indexOf("<", start)+1, it.indexOf(">", start))
                .split(",").map { it.trim().toInt() }
        return Coords(x, y, z)
    }

    fun solve2(list: Iterable<String>): Int {
        var ps = parseInput(list)
        var s = -1
        var sk = 0
        for (i in 0..Int.MAX_VALUE){
            ps = ps.groupBy{it.pp(i)}.filter { it.value.size == 1 }.flatMap { it.value }
            if(ps.size == s){
                sk++
            } else {
                s = ps.size
                sk = 0
            }
            if (sk == 1000) {
                break
            }

        }
        return ps.size
    }


    data class Coords(val x: Int,val y: Int,val z: Int){
        operator fun plus(that: Coords) = Coords(x + that.x, y + that.y, z + that.z)
    }
    data class Particle(val p: Coords,private val v: Coords,private val a: Coords){
        fun d(t: Int)= pp(t).let { abs(it.x) + abs(it.y) + abs(it.z) }

        fun pp(t: Int) = Coords(p.x + v.x * t + a.x * t * (t+1)/2,p.y + v.y * t + a.y * t * (t+1)/2, p.z + v.z * t + a.z * t *  (t+1)/2)
    }
}