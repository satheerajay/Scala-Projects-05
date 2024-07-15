
object LibraryManagement {

  case class Book(title: String, author: String, isbn: String)

  
  var library: Set[Book] = Set.empty[Book]

  
  def addBook(book: Book): Unit = {
    library = library + book
    println(s"Book '${book.title}' by ${book.author} added successfully!")
  }

  
  def removeBook(isbn: String): Unit = {
    val bookToRemove = library.find(_.isbn == isbn)
    bookToRemove match {
      case Some(book) =>
        library = library - book
        println(s"Book '${book.title}' by ${book.author} removed successfully!")
      case None =>
        println("Book not found in the library.")
    }
  }

 
  def hasBook(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  
  def displayLibrary(): Unit = {
    if (library.isEmpty) {
      println("Library is currently empty.")
    } else {
      println("** Library Collection **")
      library.foreach { book =>
        println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      }
    }
  }


  def searchBook(title: String): Unit = {
    val foundBooks = library.filter(_.title.toLowerCase.contains(title.toLowerCase))
    if (foundBooks.isEmpty) {
      println(s"No book found with title containing '$title'.")
    } else {
      println(s"** Found Books by Title: '$title' **")
      foundBooks.foreach { book =>
        println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      }
    }
  }

  def displayByAuthor(author: String): Unit = {
    val authorBooks = library.filter(_.author == author)
    if (authorBooks.isEmpty) {
      println(s"No books found by author '$author'.")
  } else {
      println(s"** Books by Author: '$author' **")
      authorBooks.foreach { book =>
        println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      }
    }
  }


  def main(args: Array[String]): Unit = {
    addBook(Book("The Lord of the Rings", " Tolkien", "9780261102694"))
    addBook(Book("Pride and Prejudice", "Jane ", "9780140439516"))
    addBook(Book("To Kill a Mockingbird", "Harper Lee", "9780446310727"))
    println()

    displayLibrary() 

    searchBook("Lord")
    println()

    displayByAuthor("Jane Austen") 
    println()

    removeBook("9780140439516") 
    println()

    displayLibrary() 
  }
}
