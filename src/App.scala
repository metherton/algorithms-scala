/**
  * Created by martin on 18/10/16.
  */
object App {

  def main(args: Array[String]): Unit = {

    // maximum pairwise product
    val input = (for {n <- 1 to 2; line = Console.readLine()} yield line).toList
    val ints = input.last.split(" ").map(_.toLong).sorted
    println(ints.init.last * ints.last)
  }

}
