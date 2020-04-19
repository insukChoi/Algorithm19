package `235`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun `예제1`() {
        val root = TreeNode(6).apply {
            left = TreeNode(2).apply {
                left = TreeNode(0)
                right = TreeNode(4).apply {
                    left = TreeNode(3)
                    right = TreeNode(5)
                }
            }
            right = TreeNode(8).apply {
                left = TreeNode(7)
                right = TreeNode(9)
            }
        }

        val p = TreeNode(2)
        val q = TreeNode(4)

        Assertions.assertEquals(TreeNode(2), Solution().lowestCommonAncestor(root, p, q))
    }

}