
object InventoryManagement {

  def getProductList: List[String] = {
    var productList: List[String] = List()
    var productName: String = ""

    do {
      println("Enter product name (or 'done' to finish):")
      productName = scala.io.StdIn.readLine()
      if (productName != "done") {
        productList = productList :+ productName
      }
    } while (productName != "done")

    productList
  }

  def printProductList(productList: List[String]): Unit = {
    productList.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(productList: List[String]): Int = {
    productList.length
  }

  def main(args: Array[String]): Unit = {
    val productList = getProductList
    println("\n--- Product List ---")
    printProductList(productList)
    println(s"\nTotal Products: ${getTotalProducts(productList)}")
  }
}
