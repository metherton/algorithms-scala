import scala.annotation.tailrec

/**
  * Created by martin on 18/10/16.
  */
object App {

  def main(args: Array[String]): Unit = {

    // maximum pairwise product
    val input = (for {n <- 1 to 2; line = Console.readLine()} yield line).toList
//    val ints = input.last.split(" ").map(_.toLong).sorted
//    println(ints.init.last * ints.last)

    @tailrec
    def loop(nums: List[Long], max: Long, nextMax: Long): Long = nums match {
      case Nil => max * nextMax
      case x :: xs => if (x > max) loop(xs, x, max) else if (x > nextMax) loop(xs, max, x) else loop(xs, max, nextMax)
    }

//    val product = loop(input.last.split(" ").map(_.toLong).toList, 0, 0)
//    println(product)

    val mpp = new MaximumPairwiseProduct(input.last.split(" ").map(_.toLong).toList)
    println(mpp.solution())
  }

}

class MaximumPairwiseProduct(val listOfLongIntegers: List[Long]) {
  def solution(): Long = {
    @tailrec
    def solution(longs: List[Long], max: Long, nextMax: Long): Long = longs match {
      case Nil => max * nextMax
      case x :: xs => if (x > max) solution(xs, x, max) else if (x > nextMax) solution(xs, max, x) else solution(xs, max, nextMax)
    }
    solution(listOfLongIntegers, 0, 0)
  }
}