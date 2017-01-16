/**
  * Created by martin on 18/10/16.
  */
object App {

  def main(args: Array[String]): Unit = {

    // introduction
    val input = (for {n <- 1 to 1; line = Console.readLine()} yield line).toList
    print(input.last.split(" ").foldLeft(0)((a, b) => a.toInt + b.toInt))

  }

}
