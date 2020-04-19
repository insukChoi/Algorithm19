package `1022`

class Solution{
    fun sumRootToLeaf(root: TreeNode?): Int {
        return sumNumbers(root, 0)
    }

    private fun sumNumbers(root: TreeNode?, sumVal: Int): kotlin.Int {
        root ?: return 0
        var sum = sumVal
        sum = sum.times(10).plus(root.`val`)
        if (root.left == null && root.right == null)
            return sum.toString().toInt(2)
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum)
    }

}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}