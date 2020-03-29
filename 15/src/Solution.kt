import kotlin.math.sign

class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        // pre condition
        val immutableHeights = heights.copyOf()
        if (immutableHeights.isEmpty()) return 0

        var output = heights.getOrElse(0){0}
        for ((index, height) in heights.withIndex()){
            var nextI = index + 1
            var sizeBasedOnHeight = height
            var flag = false  // 기준이 되는 height 가 next height 보다 한번이라도 크면 나가리 되는 플래그

            while(nextI < heights.size){
                val nextHeight = heights[nextI]

                if (height <= nextHeight && !flag){
                    sizeBasedOnHeight += height
                }else {
                    flag = true
                    sizeBasedOnHeight = heights.copyOfRange(index, nextI+1).min()!!.times((nextI - index) + 1)
                }

                output = output.coerceAtLeast(sizeBasedOnHeight)
                nextI++
            }
            heights[index] = Int.MAX_VALUE // 기준 height 의 사이즈 측정이 완료되면, MAX_VALUE 로 변환
            output = output.coerceAtLeast(sizeBasedOnHeight)
        }

        // post condition
        if (output == 0) output = immutableHeights.max()!!

        return output
    }
}