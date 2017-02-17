import scala.util.Random

object stressTest {

  val a = for {
    x <- 1 to 100000
    y = Random.nextInt(9) + 1
  } yield y
  val b = a.toArray
//  println(a)
//  val b = Array(b)
  println("start")
  new RandomizedQuickSort(100000, b)
  println("end")
 // y = Random.nextInt(1000000000)
 // val m:Int = 1200000000

//  val first = "2"
//  val second = "21"
//  val padded =  first.padTo(second.size, first(first.size - 1))

//  val absN = Math.abs(-78)



//  val nums = List("23", "39", "92", "9")
//  val nums = List("2", "8", "2", "3", "6", "4", "1", "1", "10", "6", "3", "3", "6")
  //  1 3 8 4 6 1 10 8 4 10 4 1 3 2 3 2 6 1 5 2 9 8 5 10 8 7 9 6 4 2 6 3 8 8 9 8 2 9 10 3 10 7 5 7 1 7 5 1 4 7 6 1 10 5 4 8 4 2 7 8 1 1 7 4 1 1 9 8 6 5 9 9 3 7 6 3 10 8 10 7 2 5 1 1 9 9 5

 // val nums = List("1", "10")

//  val sortedNUmer = nums.sortWith((first, second) => if (first.size < second.size) first.padTo(second.size, first(first.size - 1)) > second else if (second.size < first.size) second.padTo(first.size, second(second.size - 1)) < first   else first > second)
//  val x1 = ("23".split("").toList, "39".split("").toList).zipped.foreach((x, y) => println("x: " + x + " and y: " + y))

//  val x = ("39".split("").toList, "39".split("").toList).zipped.forall((x, y) => x > y)

//  val r = scala.util.Random
//  val testList: List[Long] = ((1 to 1000000).map(f => f * r.nextLong)).toList
//
//  val b = new MaximumPairwiseProduct(testList)
//  b.solution()
//  b.solutionWithSort()
//  val c = new MaximumPairwiseProduct(testList)
//  c.solution()
//  val f = new Fibonacci(3)
//  f.solution()

//  val myList = List(0,1)
//  myList.init.last

//  val x = "1".toInt
//
//  val myV = Vector(1,0)
//  2 +: myV
//  myV(1)
//
//  15 % 12
//
//  val gcd = new GCD(15, 10)
//  gcd.solution()
//
//  val minCoins = new MinCoins(25)
//  minCoins.solution()

 // val input = List("60 20", "100 50", "100 25")
//  val weights = input.map(line => line.split(" ").toList)
  //        .map(v => (v.head.toDouble / v.last.toDouble, v.head.toInt, v.last.toInt)).sortBy(b => b._1).reverse
  //  .map(t => Map((t._1.toInt / t._2.toInt) -> (t._1.toInt, t._2.toInt)))

//  val maxLoot = new MaxLoot(80, weights)
//  maxLoot.solution()

}