import java.util.*

class Info(var next: Int, var count: Int)

fun main() {
    val sc = Scanner(System.`in`)

    val N = sc.nextInt()
    val M = sc.nextInt()
    val stage = Array(101) { i -> Info(i, Int.MAX_VALUE) }

    for (i in 1..N) {
        val x = sc.nextInt()
        val y = sc.nextInt()

        stage[x].next = y
    }

    for (i in 1..M) {
        val x = sc.nextInt()
        val y = sc.nextInt()

        stage[x].next = y
    }

    val queue: Queue<Int> = LinkedList()
    stage[1].count = 0
    queue.offer(1)
    while (!queue.isEmpty()) {
        val top = queue.poll()
        if (top == 100) {
            println(stage[top].count)
            return
        }
        for (i in 1..6) {
            if (top + i <= 100
                && stage[stage[top + i].next].count > stage[top].count + 1
            ) {
                queue.offer(stage[top + i].next)
                stage[stage[top + i].next].count = stage[top].count + 1
            }
        }
    }
}