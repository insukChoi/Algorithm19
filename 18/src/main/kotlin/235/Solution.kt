package `235`

class Solution{
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        // validation
        root ?: return TreeNode()
        p ?: return TreeNode()
        q ?: return TreeNode()

        if (root.`val` < p.`val` && root.`val` < q.`val`){
            return lowestCommonAncestor(root.right, p, q)
        }
        if (root.`val` > p.`val` && root.`val` > q.`val`){
            return lowestCommonAncestor(root.left, p, q)
        }

        return root
    }
}

data class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}