package `997`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun `예제1`() {
        val N = 2
        val trust: Array<IntArray> = arrayOf(
            intArrayOf(1,2)
        )

        val answer = Solution().findJudge(N, trust)
        Assertions.assertEquals(2, answer)
    }

}