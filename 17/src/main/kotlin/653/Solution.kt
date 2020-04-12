package `653`
/**
653. Two Sum IV - Input is a BST
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */

class Solution {
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        if (root?.`val` == null) return false
        val set = mutableSetOf<Int>()
        return sum2ElementEqualsTarget(root, k, set)
    }

    private fun sum2ElementEqualsTarget(root: TreeNode?, k: Int, set: MutableSet<Int>): Boolean {
        if (root?.`val` == null) return false
        if (set.contains(k - root.`val`)) return true
        set.add(root.`val`)
        return sum2ElementEqualsTarget(root.left, k, set) || sum2ElementEqualsTarget(root.right, k, set)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}