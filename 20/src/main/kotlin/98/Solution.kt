package `98`

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return isValid(root = root, min = Double.NEGATIVE_INFINITY, max = Double.POSITIVE_INFINITY)
    }

    private fun isValid(root: TreeNode?, min: Double, max: Double): kotlin.Boolean {
        root ?: return true
        if (root.`val` <= min || root.`val` >= max) return false

        if (
            !isValid(root.left, min, root.`val`.toDouble())
            || !isValid(root.right, root.`val`.toDouble(), max)
        ) {
            return false
        }

        return true
    }
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}