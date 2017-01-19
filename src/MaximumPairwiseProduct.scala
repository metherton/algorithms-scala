import scala.annotation.tailrec

/**
  * Created by martin on 19/01/17.
  */
class MaximumPairwiseProduct(val listOfLongIntegers: List[Long]) {
  def solution(): Long = {
    @tailrec
    def solution(longs: List[Long], max: Long, nextMax: Long): Long = longs match {
      case Nil => max * nextMax
      case x :: xs => if (x > max) solution(xs, x, max) else if (x > nextMax) solution(xs, max, x) else solution(xs, max, nextMax)
    }
    solution(listOfLongIntegers, 0, 0)
  }

  def solutionWithSort(): Long = {
    val sortedLongs = listOfLongIntegers.sorted
    sortedLongs.last * sortedLongs.init.last
  }
}
