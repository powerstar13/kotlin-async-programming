package future

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun sum(a: Int, b: Int) = a + b

fun main() {

    val pool: ExecutorService = Executors.newSingleThreadExecutor()
    val future = pool.submit(Callable {
        sum(a = 100, b = 200)
    })

    println("계산 시작")

    val futureResult = future.get() // 비동기 작업의 결과를 기다린다. (WARN: 블로킹 상태가 되며, 타임아웃을 걸지 않으면 무한정 기다리는 상황이 발생...)
    println(futureResult)
    println("계산 종료")
}