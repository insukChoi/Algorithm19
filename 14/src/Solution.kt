class Solution {
    fun longestStrChain(words: Array<String>): Int {

        words.sortWith(Comparator { o1, o2 ->
            when {
                o1.length > o2.length -> 1
                o1.length < o2.length -> -1
                else -> 0
            }
        })

        var maxVal = 1
        for ((index, word) in words.withIndex()){
            var stringChain: MutableList<String> = arrayListOf(word)

            for ((i, w) in words.withIndex()){
                if (i == index) continue
                if ((w.length -1 == stringChain.last().length) && w.isStrChain(stringChain.last())){
                    maxVal = maxVal.coerceAtLeast(getStringChain(words, stringChain, i, w))
                    stringChain = arrayListOf(word)
                }
            }
        }

        return maxVal
    }

    private fun getStringChain(words: Array<String>, stringChain: MutableList<String>, i: Int, w: String): Int {
        stringChain.add(w)
        for (index in i until words.size){
            if (words[index].length -1 == stringChain.last().length
                    && words[index].isStrChain(stringChain.last())){
                getStringChain(words, stringChain, index , words[index])
            }
        }
        return stringChain.size
    }
}

private fun String.isStrChain(last: String): Boolean {
    for (index in this.indices) {
        if (this.removeRange(index, index+1) == last) return true
    }
    return false
}
