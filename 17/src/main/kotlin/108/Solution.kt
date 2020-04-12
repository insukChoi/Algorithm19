package `108`

/**
108. Convert Sorted Array to Binary Search Tree
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return toBST(nums, 0, nums.size -1)
    }

    private fun toBST(nums: IntArray, l: Int, r: Int): TreeNode? {
        if (l > r) return null
        val mid = (l + r) / 2
        val root = TreeNode(nums[mid])
        root.left = toBST(nums, l, mid - 1)
        root.right = toBST(nums, mid+1, r)
        return root
    }
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}