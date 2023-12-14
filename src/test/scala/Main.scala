import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class MainSpec extends AnyFlatSpec {

  "Main.computeBill" should "return £0.00 for an empty string" in {
    Main.computeBill("") shouldBe "£0.00"
  }

  it should "return £0.60 for a single apple" in {
    Main.computeBill("Apple") shouldBe "£0.60"
  }

  it should "return £0.25 for a single orange" in {
    Main.computeBill("Orange") shouldBe "£0.25"
  }

  it should "return the sum of several items" in {
    Main.computeBill("Apple, Apple, Orange, Apple") shouldBe "£2.05"
  }

}

