package boj.bruteforce

import java.util.*


class REFs {
    fun test() {

        // 2차원 배열
        val arr = Array(3) { _ -> Array<Int>(5) { 0 } }

        // 큐
        val q: Queue<Int> = LinkedList<Int>()

        // 스택
        val stack = Stack<Int>()

        // 양방향 큐
        val dq = ArrayDeque<Int>()
        dq.add(0)
        dq.addFirst(1)

        // 힙
        val pq = PriorityQueue<Int>()
        val maxpq = PriorityQueue<Int>(reverseOrder())
        // 오름차순, pair 중 앞의 요소
        val pq2 = PriorityQueue<Pair<Int, String>>(Comparator { o1, o2 -> o1.first.compareTo(o2.first) })
        pq.add(1)
        pq.add(2)
        pq.offer(2)
        pq.poll()

        // 맵
        val map = mutableMapOf<String, Int>()
        map.put("a", 122)
    }
}