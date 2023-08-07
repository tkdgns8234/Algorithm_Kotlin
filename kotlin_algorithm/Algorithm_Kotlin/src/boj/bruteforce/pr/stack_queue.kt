import java.util.*

// // 같은 숫자는 싫어
// class Solution {
//     fun solution(arr: Array<Int>) {
//         val queue: Queue<Int> = LinkedList(arr.toList())
//         val result = mutableListOf<Int>()
//         var bfVal = -1
//         while (queue.isNotEmpty()) {
//             val crVal = queue.poll()
//             if (bfVal != crVal) {
//                 result.add(crVal)
//                 bfVal = crVal
//             }
//         }
//         print(result)
//     }
// }

// fun main(){
//     val sol = Solution()
//     sol.solution(arrayOf(4,4,4,3,3))
// }


// 기능 개발
// 답
import java.util.*
import kotlin.Comparator
//class Solution {
//    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
//        var answer = IntArray(101) { 0 }
//
//        val stack: Stack<Pair<Int, Int>> = Stack()
//        for (i in progresses.size - 1 downTo 0) {
//            stack.add(Pair(progresses[i], speeds[i]))
//        }
//
//        var day = 0
//        var index = -1
//        while (stack.isNotEmpty()) {
//            index += 1
//
//            var p = stack.peek().first
//            var s = stack.peek().second
//
//            while (p + s * day < 100) {
//                day += 1
//            }
//
//            while (stack.isNotEmpty() and (p + s * day >= 100)) {
//                stack.pop()
//                answer[index] += 1
//                if (stack.isNotEmpty()) {
//                    p = stack.peek().first
//                    s = stack.peek().second
//                }
//            }
//        }
//
//        val result = mutableListOf<Int>()
//        for (i in answer) {
//            if (i != 0) {
//                result.add(i)
//            }
//        }
//        return result.toIntArray()
//    }
//}

// 올바른 괄호
//class Solution {
//    fun solution(p: String): Boolean {
//        val stack = Stack<Char>()
//
//        for (c in p) {
//            if (c == '(') {
//                stack.add('(')
//            } else {
//                if (stack.isEmpty()) { return false }
//                stack.pop()
//            }
//        }
//        return stack.isEmpty()
//    }
//}
//
//fun main() {
//    val res = Solution().solution("(()(")
//    print(res)
//}

fun main() {
    val sol = Solution()
    val res = sol.solution(intArrayOf(1, 1, 9, 1, 1, 1),	0)
    println(res)
}

//프로세스
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val queue: Queue<Pair<Int,Int>> = LinkedList()
        for (i in priorities.indices) {
            queue.add(Pair(priorities[i], i))
        }

        while (queue.isNotEmpty()) {
            // 최대 중요도 찾기
            var maxP = -1
            queue.forEach { (p,i)  ->
                if (maxP < p) maxP = p
            }

            val now = queue.peek()
            // 최대 중요도면
            if (now.first == maxP) {
                // location 일때
                if (now.second == location) {
                    return answer + 1
                } else {
                    queue.poll()
                    answer += 1
                }
            } else {
                // 최대 중요도가 아니면
                val p = queue.poll()
                queue.add(p)
            }
        }

        return answer
    }
}