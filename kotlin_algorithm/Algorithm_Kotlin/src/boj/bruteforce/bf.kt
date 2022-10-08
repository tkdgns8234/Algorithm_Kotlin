package boj.bruteforce

import java.util.*
import kotlin.math.min





class Solution7 {
    val INF = Int.MAX_VALUE

    fun dijkstra(graph: Array<MutableList<Int>>, dist: IntArray) {
        val q: Queue<Int> = LinkedList<Int>()
        q.add(1)
        dist[1] = 0

        while (q.isNotEmpty()) {
            val now = q.poll()

            graph[now].forEach {
                if (dist[it] <= dist[now] + 1) {
                    return@forEach
                }

                dist[it] = dist[now] + 1
                q.add(it)
            }
        }
    }

    fun solution(n: Int, edge: Array<IntArray>): Int {
        val dist = IntArray(n + 1) { INF }
        val graph = Array(n + 1) { mutableListOf<Int>() }

        edge.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }

        dijkstra(graph, dist)

        val maxVal = dist.maxOf { it -> if (it == INF) 0 else it }

        return dist.count { it -> it == maxVal }
    }
}

class Solution6 {
    fun binarySearch(target: Int, times: IntArray): Long {
        var ret_val: Long = Long.MAX_VALUE

        var start: Long = 0
        var end: Long = (1_000_000_000 * target.toLong())

        while (start <= end) {
            val mid = (start + end) / 2

            var cnt: Long = 0
            for (i in times) {
                cnt += (mid / i)
            }

            if (cnt < target) {
                start = mid + 1
            } else {
                ret_val = min(ret_val, mid)
                end = mid - 1
            }
        }

        return ret_val
    }

    fun solution(n: Int, times: IntArray): Long {

        return binarySearch(n, times)
    }
}

class Solution5 {
    fun bfs(start: Int, data: Array<IntArray>, visited: Array<Boolean>) {
        visited[start] = true
        var q: Queue<Int> = LinkedList<Int>()
        q.add(start)

        while (q.isNotEmpty()) {
            val now = q.poll()
            for (i in data.indices) {
                if (data[i][now] == 1 && visited[i].not()) {
                    visited[i] = true
                    q.add(i)
                }
            }
        }
    }

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        var visited = Array(n) { false }
        for (i in 0 until n) {
            if (visited[i].not()) {
                bfs(i, computers, visited)
                answer += 1
            }
        }

        return answer
    }
}

class Solution4 {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf()
        val minPQ = PriorityQueue<Int>()
        val maxPQ = PriorityQueue<Int>(reverseOrder())

        for (oper in operations) {
            val op = oper.split(" ")

            if (op[0] == "I") {
                minPQ.add(op[1].toInt())
                maxPQ.add(op[1].toInt())
            }
            else if (op[0] == "D") {
                if (op[1] == "1") {
                    val v = maxPQ.poll()
                    minPQ.remove(v)
                }
                else if (op[1] == "-1") {
                    val v = minPQ.poll()
                    maxPQ.remove(v)
                }
            }
        }

        return if (maxPQ.isNotEmpty()) {
            intArrayOf(maxPQ.poll(), minPQ.poll())
        } else {
            intArrayOf(0, 0)
        }
    }
}

class Solution3 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = IntArray(101) { 0 }

        val stack: Stack<Pair<Int, Int>> = Stack()
        for (i in progresses.size - 1 downTo 0) {
            stack.add(Pair(progresses[i], speeds[i]))
        }

        var day = 0
        var index = -1
        while (stack.isNotEmpty()) {
            index += 1

            var p = stack.peek().first
            var s = stack.peek().second

            while (p + s * day < 100) {
                day += 1
            }

            while (stack.isNotEmpty() and (p + s * day >= 100)) {
                stack.pop()
                answer[index] += 1
                if (stack.isNotEmpty()) {
                    p = stack.peek().first
                    s = stack.peek().second
                }
            }
        }

        val result = mutableListOf<Int>()
        for (i in answer) {
            if (i != 0) {
                result.add(i)
            }
        }
        return result.toIntArray()
    }
}


class Solution2 {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = mutableListOf<Int>()

        val genresMap = mutableMapOf<String, Int>()
        val playsMap = mutableMapOf<String, MutableList<MutableList<Int>>>()

        for (i in genres.indices) {
            val genre = genres[i]
            val playCnt = plays[i]

            val v = genresMap.getOrDefault(genre, 0)
            genresMap[genre] = v + playCnt
            val v2 = playsMap.getOrDefault(genre, mutableListOf())
            v2.add(mutableListOf(playCnt, i))
            playsMap[genre] = v2
        }

        playsMap.forEach {
            it.value.sortByDescending {
                it[0]
            }
        }

        val list = mutableListOf<MutableMap.MutableEntry<String, Int>>()
        for (g in genresMap) {
            list.add(g)
        }
        list.sortByDescending { it.value }

        list.forEach {
            playsMap.getValue(it.key).take(2).forEach {
                answer.add(it[1])
            }
        }

        return answer.toIntArray()
    }
}