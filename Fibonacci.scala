object FibonacciApp {
  def printfibonacci(numbers: Int): Unit = {
    for (i <- 0 until numbers) {
      println(fibonacci(i) + " ")
    }
  }

  def fibonacci(n: Int): Int = {
    if (n <= 1) {
      n
    } else {
      fibonacci(n - 1) + fibonacci(n - 2)
    }
  }

  def main(args: Array[String]): Unit = {
    val n = 10
    println(s"First $n numbers:")

    for (i <- 0 until n) {
      println(" " + i)
    }

    println("\n")
    println("Fibonacci sequence:")

    printfibonacci(n)
  }
}


