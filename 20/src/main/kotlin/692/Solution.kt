package `692`

import kotlin.streams.toList

class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val hashMap = hashMapOf<String, Int>()

        for (word in words) {
            hashMap[word] = hashMap.getOrDefault(word, 0) + 1
        }

        return hashMap.toList()
            .sortedBy { it.second }
            .reversed().toMap().entries.stream()
            .map { it.key }
            .toList()
            .subList(0, k)
    }
}