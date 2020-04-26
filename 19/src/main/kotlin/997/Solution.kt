package `997`

class Solution {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        if (trust.size < N-1) return -1

        val answerArray: IntArray = IntArray(N+1)

        for (t in trust){
            answerArray[t[0]]--
            answerArray[t[1]]++
        }

        (1..N).forEach{
            i -> if (answerArray[i] == N-1) return i
        }

        return -1
    }
}