package boj.bruteforce

import java.util.*
import kotlin.math.min
import kotlin.math.abs
import kotlin.math.max

class Solution__3번문제 {
    fun solution(K: Int, user_scores: Array<String>): Int {
        var answer = 0
        val stack = Stack<Pair<String, Int>>()
        val lankFirstPage = Array(K) { "" } // 랭킹 페이지 변동 확인을 위한 변수

        for (user_score in user_scores) {
            val info = user_score.split(" ")
            val name = info[0]
            val score = info[1].toInt()

            val idx = stack.indexOfFirst { it -> it.first == name }
            if (idx != -1) {
                if (stack[idx].second > score) {
                    // 기존 스코어보다 낮아 업데이트가 필요 없는 경우 skip
                    continue
                } else {
                    // 이미 존재하는 정보 제거
                    stack.remove(stack[idx])
                }
            }

            val temp = Stack<Pair<String, Int>>()
            while (true) {
                if (stack.isNotEmpty() && stack.peek().second < score) {
                    temp.add(stack.pop())
                } else {
                    stack.add(Pair(name, score))
                    break
                }
            }
            while (temp.isNotEmpty()) {
                stack.add(temp.pop())
            }

            var isChanged = false
            for (i in 0 until min(lankFirstPage.size, stack.size)) { // 첫 페이지 크기를 넘지 않도록 반복
                if (lankFirstPage[i] != stack[i].first) {
                    lankFirstPage[i] = stack[i].first
                    isChanged = true
                }
            }
            if (isChanged) {
                answer += 1
            }
        }

        return answer
    }
}

//fun main() {
//    val solution = Solution()
//    val v = solution.solution(
//        3,
//        arrayOf("alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200")
//    )
//    print(v)
//}


// 완전탐색 문제, 조합(백트래킹) 이용

class Solution__2번문제 {
    var result = 0
    val nums = mutableListOf<Int>()

    fun permutation(depth: Int, data: IntArray, visited: BooleanArray) {
        if (data.size == depth) {
            var total = 0
            for (i in 0 until data.size - 1) {
                total += abs(nums[i] - nums[i + 1])
            }

            result = max(result, total)
            return
        }

        for (i in data.indices) {
            if (visited[i].not()) {
                visited[i] = true
                nums.add(data[i])
                permutation(depth + 1, data, visited)
                nums.removeAt(nums.lastIndex)
                visited[i] = false
            }
        }
    }

    fun solution(v: IntArray): Int {
        val visited = BooleanArray(v.size) { false }
        permutation(0, v, visited)

        return result
    }
}


class Solution__1번문제 {
    //    am -> pm 및 시간 계산
    val solution = Solution()
    val v = solution.solution(
        "PM 01:00:00",
        60
    )

    fun solution(p: String, n: Int): String {
        val splitedString = p.split(" ")

        val amPm = if (splitedString[0] == "PM") 12 else 0

        val timeArr = splitedString[1].split(":")
        val hour = timeArr[0].toInt()
        val minute = timeArr[1].toInt()
        val second = timeArr[2].toInt()

        var totalSeconds = second + (minute * 60) + (hour * 3600) + (amPm * 3600) + n

        val oneDay = 3600 * 24 // -> 이게 12인거같아
        totalSeconds %= oneDay

        val rsHour = (totalSeconds / 3600).toString().padStart(2, '0')
        totalSeconds %= 3600
        val rsMinute = (totalSeconds / 60).toString().padStart(2, '0')
        totalSeconds %= 60
        val rsSecond = (totalSeconds).toString().padStart(2, '0')

        return "${rsHour}:$rsMinute:$rsSecond"
    }
}
