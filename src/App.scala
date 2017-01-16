/**
  * Created by martin on 18/10/16.
  */
object App {

  def main(args: Array[String]): Unit = {

    val input = (for {n <- 1 to 2; line = Console.readLine()} yield line).toList
    print(randomizedQuickSort(input.last.split(" ").map( n => n.toInt), 0, input.head.toInt))
    //for(n <- a) print(n + " ")
  }

  def randomizedQuickSort(a: Array[Int], l: Int, r: Int): Seq[Int] = {
//    if (l >= r) {
//      return
//    }
    for {n <- a} yield n
  }

//  private def partition2(a: Array[Int], l: Int, r: Int): Int = {
//    val x: Int = a(l)
//    var j: Int = l
//    {
//      var i: Int = l + 1
//      while (i <= r) {
//        {
//          if (a(i) <= x) {
//            j += 1
//            val t: Int = a(i)
//            a(i) = a(j)
//            a(j) = t
//          }
//        }
//        ({
//          i += 1; i - 1
//        })
//      }
//    }
//    val t: Int = a(l)
//    a(l) = a(j)
//    a(j) = t
//    return j
//  }

}

//class Sorting(a: Array[Int], l: Int, r: Int)
//
//private def randomizedQuickSort(a: Array[Int], l: Int, r: Int) {
//  if (l >= r) {
//    return
//  }
//  val k: Int = random.nextInt(r - l + 1) + l
//  val t: Int = a(l)
//  a(l) = a(k)
//  a(k) = t
//  val m: Int = partition2(a, l, r)
//  randomizedQuickSort(a, l, m - 1)
//  randomizedQuickSort(a, m + 1, r)
//}