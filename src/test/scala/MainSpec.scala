import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class MainSpec extends AnyFlatSpec {

  "Main.computeBill" should "return £0.00 for an empty string" in {
    Main.computeBill("", withDeal = false) shouldBe "£0.00"
  }

  it should "return £0.60 for a single apple" in {
    Main.computeBill("Apple", withDeal = false) shouldBe "£0.60"
  }

  it should "return £0.25 for a single orange" in {
    Main.computeBill("Orange", withDeal = false) shouldBe "£0.25"
  }

  it should "return the sum of several items" in {
    Main.computeBill("Apple, Apple, Orange, Apple", withDeal = false) shouldBe "£2.05"
  }

  it should "return a simple cost when a deal is applied" in {
    Main.computeBill("Apple, Orange, Orange", withDeal = true) shouldBe "£1.10"
  }

  it should "return a complex cost when a deal is applied" in {
    Main.computeBill("Apple, Orange, Orange, Apple, Orange, Apple, Orange", withDeal = true) shouldBe "£1.95"
  }

}
