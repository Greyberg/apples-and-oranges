import scala.annotation.tailrec

object Main extends App {

  def computeBill(input: String, withDeal: Boolean): String = {

    val itemList = input.split(", ").toList

    @tailrec
    def addFruits(list: List[String], acc: (Int, Int)): (Int, Int) = {
      list match {
        case Nil => acc
        case head::tail => if (head == "Apple") {
          addFruits(tail, (acc._1 + 1, acc._2))
        } else if (head == "Orange") {
          addFruits(tail, (acc._1, acc._2 + 1))
        } else {
          addFruits(tail, (acc._1, acc._2))
        }
      }
    }

    val (apples, oranges) = addFruits(itemList, (0, 0))

    val result = if (withDeal) {
      ((apples/2).floor + apples%2) * 0.6 + (oranges/3).floor * 0.5 + oranges%3 * 0.25
    } else {
      apples * 0.6 + oranges * 0.25
    }

    f"£$result%.2f"
  }
}
