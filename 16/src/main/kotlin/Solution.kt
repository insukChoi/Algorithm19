class Solution {
    fun shipWithinDays(weights: IntArray, D: Int): Int {
        var low = 0
        var high = weights.sum()
        while (low < high) {
            val mid = low + (high - low) / 2
            if (checkValid(weights, mid, D)) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        return low
    }

    private fun checkValid(weights: IntArray, mid: Int, D: Int): Boolean {
        var index = 0
        var count = 0
        while (index < weights.size) {
            var curShip = 0
            while (index < weights.size && curShip + weights[index] <= mid) {
                curShip = curShip.plus(weights[index++])
            }
            count++
            if (count > D) {
                return false
            }
        }
        return true
    }
}
