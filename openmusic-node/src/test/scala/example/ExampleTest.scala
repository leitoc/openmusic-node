package example
import org.specs2.mutable.Specification
import org.specs2.matcher.ShouldMatchers
import org.specs2.mutable._


class ExampleTest extends Specification {

  "Basic test" should {
    "map doubles from a list" in {
      val list = List(1,2,3)
      val result = list.map (n => n*2)
      val expected= List(2,4,6)
      result must be equalTo(expected)
    }
  }
   
  
}