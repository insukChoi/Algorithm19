package `108`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun `예제1`() {
        val intArr = intArrayOf(-10, -3, 0, 5, 9)

        val resultTree = TreeNode(0).apply {
            left = TreeNode(-3).apply {
                left = TreeNode(-10)
            }
            right = TreeNode(9).apply {
                left = TreeNode(5)
            }
        }

        Assertions.assertEquals(resultTree.toString(), Solution().sortedArrayToBST(intArr).toString())
    }

}