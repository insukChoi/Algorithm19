import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun `예제1`() {
        // given
        val weight = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val D = 5

        // when
        val result = Solution().shipWithinDays(weight, D)

        // then
        assertEquals(15, result)
    }

    @Test
    fun `예제2`() {
        // given
        val weight = intArrayOf(3, 2, 2, 4, 1, 4)
        val D = 3

        // when
        val result = Solution().shipWithinDays(weight, D)

        // then
        assertEquals(6, result)
    }

    @Test
    fun `예제3`() {
        // given
        val weight = intArrayOf(1, 2, 3, 1, 1)
        val D = 4

        // when
        val result = Solution().shipWithinDays(weight, D)

        // then
        assertEquals(3, result)
    }
}
