package `1022`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun `예제1`() {
        val intArr = TreeNode(0).apply {
            left = TreeNode(0).apply {
                left = TreeNode(0)
                right = TreeNode(1)
            }
            right = TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(1)
            }
        }


        Assertions.assertEquals(22, Solution().sumRootToLeaf(intArr))
    }

}