import java.util.*

//프로그래머스 폰켓몬
//set 자료구조 이용한 풀이
// class Solution {
//     fun solution(nums: Array<Int>): Int {
//         return nums.toSet().size
//     }
// }

// // map 자료구조 이용한 풀이
// class Solution1 {
//     fun solution(nums: Array<Int>): Int {
//         var answer = 0
//         val map = mutableMapOf<Int, Int>()
//         for (key in 1..20000) {
//             map[key] = 0
//         }

//         for (n in nums) {
//             val value = map.getOrDefault(n, 0)

//             if (value == 0) {
//                 answer += 1
//                 map[n] = 1
//             }
//         }

//         return answer
//     }
// }


// fun main() {
//     val sol = Solution1()
//     val retVal = sol.solution(arrayOf(1,23,4,5,5,5))
//     print(retVal)
// }


// // 완주하지 못한 선수
// class Solution {
//     fun solution(participant: Array<String>, completion: Array<String>): String {
//         var answer = ""
//         val map = mutableMapOf<String, Int>()

//         for (p in participant) {
//             val mapValue = map.getOrDefault(p, 0)
//             map[p] = mapValue + 1
//         }

//         completion.forEach { c ->
//             val mapValue = map.getOrDefault(c, 0)
//             map[c] = mapValue - 1
//         }

//         map.keys.forEach { key ->
//             val mapValue = map.getOrDefault(key, 0)
//             if (mapValue > 0) {
//                 answer = key
//             }
//         }

//         return answer
//     }
// }

// fun main() {
//     val sol = Solution()
//     val result = sol.solution(arrayOf("leo", "kiki", "eden"), arrayOf("eden", "kiki"))
//     print(result)
// }

// 전화번호 목록
// class Solution {
//     fun solution(phone_book: Array<String>): Boolean {
//         phone_book.sort()
//         for (i in 0..phone_book.size - 2) {
//             val isStart = phone_book[i + 1].startsWith(phone_book[i])
//             if (isStart) {
//                 return false
//             }
//         }
//         return true
//     }
// }

// fun main() {
//     val sol = Solution()
//     val result = sol.solution(arrayOf("12","123","1235","567","88"))
//     print(result)
// }


// 의상
// 실패, 간단히 생각해서 넣는경우오 ㅏ넣지 않는 두경우로 나뉨, 모두 넣지 않는경우의수만 빼면 됨
