object Day4 {

    fun solve(list: Iterable<String>): Int {
        return list.count { isValid(it) }
    }

    private fun isValid(phrase: String): Boolean {
        val set = HashSet<String>()
        phrase.split(" ").forEach {
            if (!set.add(it)){
                return false
            }
        }
        return true
    }

    fun solve2(list: Iterable<String>): Int {
        return list.count { isValid2(it) }
    }

    fun isValid2(phrase: String): Boolean {
        val set = HashSet<String>()
        phrase.split(" ").forEach {
            if (!set.add(it.toCharArray().sorted().toString())){
                return false
            }
        }
        return true
    }


}
