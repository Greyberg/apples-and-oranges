import scala.annotation.tailrec

object Main extends App {

  def computeBill(input: String): String = {

    val itemList = input.split(", ").toList

    def itemCost(input: String): Double = if (input == "Apple") {
      0.60
    } else if (input == "Orange") {
      0.25
    } else {
      0
    }

    @tailrec
    def addCosts(list: List[String], acc: Double): Double = {
      list match {
        case Nil => acc
        case head::tail => addCosts(tail, acc + itemCost(head))
      }
    }

    val result = addCosts(itemList, 0)

    f"£$result%.2f"
  }
}

