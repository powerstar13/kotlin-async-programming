package completablefuture

import future.sum
import java.util.concurrent.Callable
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {

    val completableFuture = CompletableFuture.supplyAsync {
        Thread.sleep(2000)
        sum(a = 100, b = 200)
    }

    println("계산 시작")

    completableFuture.thenApplyAsync(::println) // 논블로킹으로 동작

//    val result = completableFuture.get() // 블로킹으로 동작
//    println(result)

    while (!completableFuture.isDone) {
        Thread.sleep(500)
        println("계산 결과를 집계 중입니다.")
    }

    println("계산 종료")
}