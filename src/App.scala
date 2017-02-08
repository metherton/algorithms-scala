import scala.annotation.tailrec
import scala.collection.immutable.Stream.Empty

/**
  * Created by martin on 18/10/16.
  */
object App {

  def main(args: Array[String]): Unit = {

    // fibonacci
//    val input = (for {n <- 1 to 1; line = Console.readLine()} yield line).toList

    // maximum pairwise product
 //   val input = (for {n <- 1 to 2; line = Console.readLine()} yield line).toList
 //   def sortNumbers(first: String, second: String): Boolean = (first.split("").toList, second.split("").toList).zipped.forall((x, y) => x >= y)

//    val ints = input.last.split(" ").toList.sortWith((first, second) => if (first.size < second.size) first.padTo(second.size, first(first.size - 1)) > second else if (second.size < first.size) second.padTo(first.size, second(second.size - 1)) < first   else first > second)
 //   val ints = input.last.split(" ").toList.sortWith((first, second) => first + second > second + first)
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
//    val fibVal = new Fibonacci(input.head.toInt)
 //   println(fibVal.solution())

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
//    val firstLine = (for {n <- 1 to 1; line = Console.readLine()} yield line).toList
//    val firstLineSplit = firstLine.last.split(" ").map(_.toInt)
//    val otherLines = (for {n <- 1 to firstLineSplit.head; line = Console.readLine()} yield line).toList
//    val weights = otherLines.map(line => line.split(" ").toList)
//      .map(v => ((v.head.toDouble / v.last.toDouble), v.head.toInt, v.last.toInt)).sortBy(b => b._1).reverse
//
//    val maxLoot = new MaxLoot(firstLineSplit.last, weights)
//    println(maxLoot.solution())


    // max dot product
//    val lines = (for {n <- 1 to 3; line = Console.readLine()} yield line).toList
//    val n = lines(0).toLong
//    val valuePerClick = lines(1).split(" ").map(_.toLong).sorted
//    val numberOfClicks = lines(2).split(" ").map(_.toLong).sorted
//    val clickValues = (valuePerClick.zip(numberOfClicks)).toList
//
//    val maxDotProduct = new MaxDotProduct(n, clickValues)
//    println(maxDotProduct.solution())

    // collecting signatures
//    val firstLine = (for {n <- 1 to 1; line = Console.readLine()} yield line).toList
//    val numberOfSegments = firstLine.head.toInt
//    val otherLines = (for {n <- 1 to numberOfSegments; line = Console.readLine()} yield line).toList
//    val segments = otherLines.map(line => line.split(" ").toList).map(line => (line(0).toLong, line(1).toLong)).sortBy(e => e._2)
//    val minSegments = new MinSegment(numberOfSegments, segments)
//    val solution = minSegments.solution()
//    println(solution.size)
//    val nums = solution.mkString(" ")
//    println(nums)

    // maxPairwise
    //    val fibVal = new Fibonacci(input.head.toInt)
    //    println(fibVal.solution())

    // maxprizes
//    val maxPrizes = new MaxPrizes(input.head.toInt)
//    val solution = maxPrizes.solution()
//    println(solution.size)
//    val nums = solution.mkString(" ")
//    println(nums)
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

      // maxPairwise
//      val maxSalary = new MaxSalary(input.head.toLong, ints: List[String])
  //    println(maxSalary.solution())

    //Binary search
//    val input = (for {n <- 1 to 2; line = Console.readLine()} yield line).toList
//    val firstLine = input.head
//    val secondLine = input.last
//    val n = firstLine.split(" ").toList.head.toLong
//    val sortedNumbers = firstLine.split(" ").toVector.tail.map(_.toLong)
//    val k = secondLine.split(" ").toList.head.toLong
//    val unsortedNumbers = secondLine.split(" ").toVector.tail.map(_.toLong)
//    new BinarySearch(n, sortedNumbers, k, unsortedNumbers)

    //Majority element
    val input = (for {n <- 1 to 2; line = Console.readLine()} yield line).toList
    val firstLine = input.head
    val secondLine = input.last
    val n = firstLine.toInt
    val numbersToCheck = secondLine.split(" ").toVector.map(_.toInt)
    new MajorityElement(n, numbersToCheck)

  }

}

class MajorityElement(n: Int, val numbersToCheck: Vector[Int]) {
  def loop(numbersToCheck: Vector[Int], left: Int, right: Int): Int = {
    if (left == right) return -1
    if (left + 1 == right) return numbersToCheck(left)
    val mid = Math.floor(left + ((right - left) / 2)).toInt
    val leftSide: Int = loop(numbersToCheck, left, mid)
    val rightSide: Int = loop(numbersToCheck, mid, right)
    var leftCount = 0
    var rightCount = 0

    val majorityNumber = Math.floor((right - left) / 2)

    if (leftSide == -1 && rightSide != -1) {
      for (i <- left to right - 1) {
        if (numbersToCheck(i) == rightSide) {
          rightCount += 1
        }
      }
      if (rightCount > majorityNumber) return rightSide
      else return -1
    }
    else if (rightSide == -1 && leftSide != -1) {
      for (i <- left to right - 1) {
        if (numbersToCheck(i) == leftSide) leftCount +=1
      }
      if (leftCount > majorityNumber) return leftSide
      else return -1
    }
    else if (leftSide != -1 && rightSide != -1) {
      for (i <- left to right - 1) {
        if (numbersToCheck(i) == leftSide) leftCount += 1
        if (numbersToCheck(i) == rightSide) rightCount += 1
      }
      if (leftCount > majorityNumber) return leftSide
      else if (rightCount > majorityNumber) return rightSide
    }
    return -1

  }

  if (loop(numbersToCheck, 0, numbersToCheck.length) != -1) println(1) else println(0)


}

class BinarySearch(val n: Long, val sortedNumbers: Vector[Long], val k: Long, unsortedNumbers: Vector[Long]) {
 // println("n:" + n + " sortedNumbers:" + sortedNumbers + " k: " + k + " unsortedNumebr:" + unsortedNumbers)

  def loop(k: Long, low: Long, high: Long): Long = {
    if (high < low) return -1
    val mid = Math.abs(low + (high - low)/2)
    if (k == sortedNumbers(mid.toInt)) return mid
    else if (k < sortedNumbers(mid.toInt)) return loop(k, low, mid - 1)
    else return loop(k, mid + 1, high)
  }


  val result = for {
    numberToFind <- unsortedNumbers
    position = loop(numberToFind, 0, sortedNumbers.size - 1)
  } yield position

  println(result.mkString(" "))
}

class MaxSalary(val n: Long, val numbers: List[String]) {

  println(numbers.mkString(""))

//  def isGreaterOrEqual(first: String, second: String): Boolean = first.toString >= second.toString
//
//  def solution(): Vector[Long] = {
//     def solution(numsSoFar: Vector[Long], accum: Vector[Long]): Vector[Long] = numsSoFar match {
//       case IndexedSeq() => accum
//
//     }
//     solution(numbers, Vector())
//
//
//  }


//  def solution(): Vector[Long] = {
//    def solution(leftOver: Long, series: Vector[Long], lastKnown: Long): Vector[Long] = leftOver match {
//      case 0 => series
//      case _ => if (leftOver <= 2 * lastKnown) solution(0, series :+ leftOver, lastKnown) else solution(leftOver - lastKnown, series :+ lastKnown, lastKnown + 1)
//    }
//    solution(n, Vector(), 1)
//  }

}

class MaxPrizes(val n: Long) {
  def solution(): Vector[Long] = {
    def solution(leftOver: Long, series: Vector[Long], lastKnown: Long): Vector[Long] = leftOver match {
      case 0 => series
      case _ => if (leftOver <= 2 * lastKnown) solution(0, series :+ leftOver, lastKnown) else solution(leftOver - lastKnown, series :+ lastKnown, lastKnown + 1)
    }
    solution(n, Vector(), 1)
  }

}

class MinSegment(val numberOfSegments: Int, val segments: List[(Long, Long)]) {



  def solution(): List[Long] = {

    def solution(segs: List[(Long, Long)], accum: List[Long], minRight: Long): List[Long] = segs match {
      case Nil => accum
      case x :: xs => if (x._1 <= minRight) solution(xs, accum, minRight) else solution(xs, accum :+ x._2, x._2)
    }
    solution(segments, List(), -1)
  }

}


class MaxLoot(val capacity: Int, val valueWeights: List[(Double, Int, Int)]) {

  def solution(): Double = {

    def solution(valueSoFar: Double, weightSoFar: Int, valWeights: List[(Double, Int, Int)]): Double = weightSoFar match {
      case `capacity` => valueSoFar
      case _ => valWeights match {
        case Nil => valueSoFar
        case x :: xs => if (x._3 + weightSoFar <= capacity) solution(valueSoFar + x._2, weightSoFar + x._3, xs) else solution(valueSoFar + (x._2 * (capacity - weightSoFar).toDouble/x._3), weightSoFar + (capacity - weightSoFar), xs)
      }
    }
    solution(0, 0, valueWeights)
  }

}

class MaxDotProduct(val numberOfValues: Long, val clickValues: List[(Long, Long)]) {

  def solution(): Long = {

    def solution(clicks: List[(Long, Long)], accum: Long): Long = clicks match {
      case Nil => accum
      case x :: xs => solution(xs, accum + (x._1 * x._2))
    }
    solution(clickValues, 0)
  }

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

  def loop(currentIndex: Long, last: Long, lastButOne: Long): Long = currentIndex match {
    case `n`  => last + lastButOne
    case _ => loop(currentIndex + 1, last + lastButOne, last)
  }

  if (n == 0) println(1)
  else if (n == 1) println(1)
  else {
    val result = loop(2, 1, 0)
    println(result)
  }

}

//class Fibonacci(val n: Long) {
//  def solution(): BigInt = {
//    def solution(vals: Vector[BigInt]): Vector[BigInt] = vals.size - 1 match {
//      case `n` => vals
//      case _ => solution(vals :+ (vals.init.last + vals.last))
//    }
//    val fibSeq = if (n <= 1) Vector[BigInt](0,1) else solution(Vector(0, 1))
//    fibSeq(n.toInt)
//  }
//
//}

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

//class FibonacciSum(val n: Long) {
//  def solution(): Long = {
//    val fibSum = (new Fibonacci((n + 2) % 60)).solution() - 1
//    fibSum.toString().takeRight(1).toInt
//  }
//}

//class FibonacciSumPartial(val m: Long, val n: Long) {
//  def solution(): Long = {
//    def loop(begin: Long, end: Long, accum: BigInt): BigInt = {
//      end match {
//        case `begin` => accum
//        case _ => loop(begin, end - 1, accum + (new Fibonacci((end - 1) % 60)).solution())
//      }
//    }
//    val begin = m % 60
//    val end = n % 60
//
//    val s = loop(begin, end, (new Fibonacci(end)).solution())
//    s.toString().takeRight(1).toInt
//  }
//}

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