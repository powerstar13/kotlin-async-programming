package thread

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {

    val pool: ExecutorService = Executors.newFixedThreadPool(5) // 스레드를 유지할 개수를 지정할 수 있다.

    try {
        for (i in 0..5) {
            pool.execute {
                println("current-thread-name: ${Thread.currentThread().name}")
            }
        }
    } finally {
        pool.shutdown()
    }
    println("current-thread-name: ${Thread.currentThread().name}")
}