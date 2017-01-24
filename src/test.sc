

object stressTest {

//  val r = scala.util.Random
//  val testList: List[Long] = ((1 to 1000000).map(f => f * r.nextLong)).toList
//
//  val b = new MaximumPairwiseProduct(testList)
//  b.solution()
//  b.solutionWithSort()
//  val c = new MaximumPairwiseProduct(testList)
//  c.solution()
  val f = new Fibonacci(3)
  f.solution()

//  val myList = List(0,1)
//  myList.init.last

  val x = "1".toInt

  val myV = Vector(1,0)
  2 +: myV
  myV(1)

  15 % 12

  val gcd = new GCD(15, 10)
  gcd.solution()

  val minCoins = new MinCoins(25)
  minCoins.solution()

  val input = List("60 20", "100 50", "100 25")
  val weights = input.map(line => line.split(" ").toList)
          .map(v => (v.head.toInt / v.last.toInt, v.head.toInt, v.last.toInt)).sortBy(b => b._1).reverse
  //  .map(t => Map((t._1.toInt / t._2.toInt) -> (t._1.toInt, t._2.toInt)))


}