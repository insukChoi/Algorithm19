package `692`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun `예제1`() {
        val words = arrayOf("i", "love", "leetcode", "i", "love", "coding")
        val k = 2

        val answer = Solution().topKFrequent(words, k)
        Assertions.assertEquals(
            listOf("i", "love"),
            answer
        )
    }

    @Test
    fun `예제2`() {
        val words = arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is")
        val k = 4

        val answer = Solution().topKFrequent(words, k)
        Assertions.assertEquals(
            listOf("the", "is", "sunny", "day"),
            answer
        )
    }
}