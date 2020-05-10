package `98`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun `예제1`() {
        val root = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }

        Assertions.assertEquals(true, Solution().isValidBST(root))
    }

    @Test
    fun `예제2`() {
        val root = TreeNode(5).apply {
            left = TreeNode(1)
            right = TreeNode(4).apply {
                left = TreeNode(3)
                right = TreeNode(6)
            }
        }

        Assertions.assertEquals(false, Solution().isValidBST(root))
    }

    @Test
    fun `예제3`() {
        val root = TreeNode(10).apply {
            left = TreeNode(5)
            right = TreeNode(15).apply {
                left = TreeNode(6)
                right = TreeNode(20)
            }
        }

        Assertions.assertEquals(false, Solution().isValidBST(root))
    }

    @Test
    fun `예제4`() {
        val root = TreeNode(0)
        Assertions.assertEquals(true, Solution().isValidBST(root))
    }
}