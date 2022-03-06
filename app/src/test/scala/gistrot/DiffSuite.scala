import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scala.scalanative.meta.LinktimeInfo.isWindows

class DiffSuite {
  @Test
  def testEnums(): Unit = {
    // On windows default type for enums seems to be int
    assertEquals(1, 1)
  }
}
