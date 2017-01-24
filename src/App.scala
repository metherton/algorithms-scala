import scala.annotation.tailrec

/**
  * Created by martin on 18/10/16.
  */
object App {

  def main(args: Array[String]): Unit = {

    // fibonacci
//    val input = (for {n <- 1 to 1; line = Console.readLine()} yield line).toList

    // maximum pairwise product
//    val input = (for {n <- 1 to 2; line = Console.readLine()} yield line).toList
//    val ints = input.last.split(" ").map(_.toLong).sorted
//    println(ints.init.last * ints.last)

    @tailrec
    def loop(nums: List[Long], max: Long, nextMax: Long): Long = nums match {
      case Nil => max * nextMax
      case x :: xs => if (x > max) loop(xs, x, max) else if (x > nextMax) loop(xs, max, x) else loop(xs, max, nextMax)
    }

//    val mpp = new MaximumPairwiseProduct(input.last.split(" ").map(_.toLong).toList)
//    println(mpp.solution())

    // fibonaaci
//    val fibVal = new Fibonacci(input.head.toInt)
//    println(fibVal.solution())

    // fibonaaci last digit
//    val fibValLastDigit = new FibonacciLastDigit(input.head.toInt)
//    println(fibValLastDigit.solution())

    // gcd
//    val ints = input.last.split(" ").map(_.toInt)
//    val gcd = new GCD(ints.head, ints.tail.head)
//    println(gcd.solution())

    // lcm
//    val ints = input.last.split(" ").map(_.toInt)
//    val lcm = new LCM(ints.head, ints.tail.head)
//    println(lcm.solution())

    // Fib modulo
//    val ints = input.last.split(" ").map(_.toLong)
//    val mod = new FibonacciModulo(ints.head.toLong, ints.tail.head)
//    println(mod.solution())

    // fibonaaci sum
//    val fibVal = new FibonacciSum(input.head.toLong)
//    println(fibVal.solution())

    // min coins
//      val minCoins = new MinCoins(input.head.toInt)
//      println(minCoins.solution())

    // max loot
    val firstLine = (for {n <- 1 to 1; line = Console.readLine()} yield line).toList
    val firstLineSplit = firstLine.last.split(" ").map(_.toInt)
    val otherLines = (for {n <- 1 to firstLineSplit.head; line = Console.readLine()} yield line).toList
//    val valueWeights = otherLines.map(line => line.split(" ").map(a => Map((a.head / a.last).toDouble, (a.head.toInt, a.last.toInt))).sorted)
//    val valueWeights = otherLines.map(line => line.split(" ").map(a => Map((a.head / a.last).toDouble, (a.head.toInt, a.last.toInt))).sorted)
    val weights = otherLines.map(line => line.split(" ").toList)
      .map(v => ((v.head.toDouble / v.last.toDouble), v.head.toInt, v.last.toInt)).sortBy(b => b._1).reverse

    val maxLoot = new MaxLoot(firstLineSplit.last, weights)
  //  println(maxLoot.solution())

    // fibonaaci sum partial
//    val ints = input.last.split(" ").map(_.toLong)
//    val fibVal = new FibonacciSumPartial(ints.head, ints.tail.head)
//    println(fibVal.solution())

//    def fib(x: Int): BigInt = {
//      @tailrec def fibHelper(x: Int, prev: BigInt = 0, next: BigInt = 1): BigInt = x match {
//        case 0 => prev
//        case 1 => next
//        case _ => fibHelper(x - 1, next, (next + prev))
//      }
//      fibHelper(x)
//    }
//
//    println(fib(input.head.toInt))


  }




}

class MaxLoot(val capacity: Int, val valueWeights: List[(Double, Int, Int)]) {
  println("capacity: " + capacity)
  println("value weights" + valueWeights)
//  def solution(): Int = {
//
//    def solution(amount: Int, numberOfCoins: Int): Int = amount match {
//      case 0 => numberOfCoins
//      case _ => if (amount >= 10) solution(amount - 10, numberOfCoins + 1)
//      else if (amount >= 5) solution(amount - 5, numberOfCoins + 1)
//      else solution(amount - 1, numberOfCoins + 1)
//    }
//    solution(capacity, 0)
//  }

}

class FibonacciLastDigit(val n: Int) {
  def solution(): Int = {
    def solution(vals: Vector[Int]): Vector[Int] = vals.size - 1 match {
      case `n` => vals
      case _ => solution((vals.tail.head + vals.head) % 10 +: vals)
    }
    val fibSeq = if (n <= 1) Vector[Int](1,0) else solution(Vector(1,0))
    fibSeq(0) % 10
  }

}

//class FibonacciLastDigit(val n: Int) {
//  def solution(): BigInt = {
//    def solution(vals: Vector[BigInt]): Vector[BigInt] = vals.size - 1 match {
//      case `n` => vals
//      case _ => solution(vals :+ (vals.init.last + vals.last) % 10)
//    }
//    val fibSeq = if (n <= 1) Vector[BigInt](0,1) else solution(Vector(0, 1))
//    fibSeq(n) % 10
//  }
//
//}

//class FibonacciLastDigit(val n: Int) {
//  def solution(): BigInt = {
//    def solution(vals: List[BigInt]): List[BigInt] = vals.size - 1 match {
//      case `n` => vals
//      case _ => solution(vals :+ (vals.init.last + vals.last) % 10)
//    }
//    val fibSeq = if (n <= 1) List[BigInt](0,1) else solution(List(0, 1))
//    fibSeq(n)
//  }
//
//}

class Fibonacci(val n: Long) {
  def solution(): BigInt = {
    def solution(vals: Vector[BigInt]): Vector[BigInt] = vals.size - 1 match {
      case `n` => vals
      case _ => solution(vals :+ (vals.init.last + vals.last))
    }
    val fibSeq = if (n <= 1) Vector[BigInt](0,1) else solution(Vector(0, 1))
    fibSeq(n.toInt)
  }

}

class MinCoins(val n: Int) {
  def solution(): Int = {

    def solution(amount: Int, numberOfCoins: Int): Int = amount match {
      case 0 => numberOfCoins
      case _ => if (amount >= 10) solution(amount - 10, numberOfCoins + 1)
      else if (amount >= 5) solution(amount - 5, numberOfCoins + 1)
      else solution(amount - 1, numberOfCoins + 1)
    }
    solution(n, 0)
  }

}

class FibonacciSum(val n: Long) {
  def solution(): Long = {
    val fibSum = (new Fibonacci((n + 2) % 60)).solution() - 1
    fibSum.toString().takeRight(1).toInt
  }
}

class FibonacciSumPartial(val m: Long, val n: Long) {
  def solution(): Long = {
    def loop(begin: Long, end: Long, accum: BigInt): BigInt = {
      end match {
        case `begin` => accum
        case _ => loop(begin, end - 1, accum + (new Fibonacci((end - 1) % 60)).solution())
      }
    }
    val begin = m % 60
    val end = n % 60

    val s = loop(begin, end, (new Fibonacci(end)).solution())
    s.toString().takeRight(1).toInt
  }
}

class GCD(val a: Long, val b: Long) {
  def solution(): Long = {
     def solution(a: Long, b: Long): Long = b match {
       case 0 => a
       case  _ => solution(b, a % b)
     }
    solution(a, b)
  }

}

class LCM(val a: Long, val b: Long) {
  def solution(): Long = {
    val gcd = new GCD(a, b)
    return (a * b) / gcd.solution()
  }

}

class FibonacciModulo(val n: Long, val m: Long) {
  def solution(): Long = {

    @tailrec
    def loop(first: Long, second: Long, pisano: Long): Long = (first, second) match {
      case (0, 1) => pisano + 1
      case _ => loop(second, (first + second) % m, pisano + 1)
    }

    @tailrec
    def loop2(counter: Long, result: Long, first: Long, second: Long): Long = counter match {
      case -1 => result
      case 0 => result
      case _ => loop2(counter - 1, (first + second) % m, second, (first + second) % m)
    }

    val remainder = n % loop(1, 1, 0)

    loop2(remainder - 1, remainder, 0, 1) %  m

  }

}