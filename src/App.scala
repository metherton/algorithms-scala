import scala.annotation.tailrec

/**
  * Created by martin on 18/10/16.
  */
object App {

  def main(args: Array[String]): Unit = {

    // fibonacci
    val input = (for {n <- 1 to 1; line = Console.readLine()} yield line).toList

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
    val fibValLastDigit = new FibonacciLastDigit(input.head.toInt)
    println(fibValLastDigit.solution())
  }

}

class FibonacciLastDigit(val n: Int) {
  def solution(): BigInt = {
    def solution(vals: List[BigInt]): List[BigInt] = vals.size - 1 match {
      case `n` => vals
      case _ => solution(vals :+ (vals.init.last + vals.last) % 10)
    }
    val fibSeq = if (n <= 1) List[BigInt](0,1) else solution(List(0, 1))
    fibSeq(n)
  }

}

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

class Fibonacci(val n: Int) {
  def solution(): BigInt = {
    def solution(vals: List[BigInt]): List[BigInt] = vals.size - 1 match {
      case `n` => vals
      case _ => solution(vals :+ (vals.init.last + vals.last))
    }
    val fibSeq = if (n <= 1) List[BigInt](0,1) else solution(List(0, 1))
    fibSeq(n)
  }

}
