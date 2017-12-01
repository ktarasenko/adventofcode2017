object Day1 {

    fun solve(list: String): Int {
        var s = 0
        for (i in 0 until list.length){
            if (list[i] == list[(i+1) % (list.length)]){
                s += list[i] - '0'
            }
        }
        return s
    }

    fun solve2(list: String): Int {
        var s = 0
        var d = list.length/ 2
        for (i in 0 until list.length){
            if (list[i] == list[(i+d) % (list.length)]){
                s += list[i] - '0'
            }
        }
        return s
    }

}
