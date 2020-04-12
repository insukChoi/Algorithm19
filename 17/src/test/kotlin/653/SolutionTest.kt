package `653`
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun `예제1`() {
        val root = TreeNode(5).apply {
            left = TreeNode(3).apply {
                left = TreeNode(2)
                right = TreeNode(4)
            }
            right = TreeNode(6).apply {
                right = TreeNode(7)
            }
        }
        assertEquals(true, Solution().findTarget(root, 9))
    }

    @Test
    fun `예제2`() {
        val root = TreeNode(5).apply {
            left = TreeNode(3).apply {
                left = TreeNode(2)
                right = TreeNode(4)
            }
            right = TreeNode(6).apply {
                right = TreeNode(7)
            }
        }
        assertEquals(false, Solution().findTarget(root, 28))
    }

    @Test
    fun `예제3`() {
        val root = TreeNode(1)
        assertEquals(false, Solution().findTarget(root, 2))
    }

}