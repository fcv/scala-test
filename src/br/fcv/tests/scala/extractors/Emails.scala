package br.fcv.tests.scala.extractors

/**
 * Example of Extractors usage taken from Programming in Scala book
 */
object Email extends Application {

  object Email {
    def apply(user:String, domain: String) = user + "@" + domain
    
    def unapply(email: String): Option[(String, String)] = {
      val parts = email split "@"
      if (parts.length == 2) Some(parts(0), parts(1)) else None
    }
  }
  
  object Domain {
    def apply(subdomains: String*):String = subdomains.reverse.mkString(".") 
    def unapplySeq(domain: String): Option[Seq[String]] = {
      val subdomains = domain split "\\."
      Some( subdomains reverse )
    } 
  }
  
  def printEmailFields(email: String) = {
    email match {
	  case Email(user, domain) => println("user: " + user + ", domain: " + domain)
	  case _ => println("'" + email + "' is a valid email")
	}
  }
  
  def printUsersFromBrServers(email: String) = {
    email match {
      case Email(user, Domain("br", _*)) => println (email)
      case _ => //-- just ignore
    }
  }
  
  
  printEmailFields("genesio@server.com.br")
  printEmailFields("someordinarystring")
  //-- prints:
  // user: genesio, domain: server.com.br
  // 'someordinarystring' is a valid email
  
  println
  
  List("genesio@server.com.br", "invalidemail", "user@notbrserver.com", "baltazar@anotherserver.com.br") foreach printUsersFromBrServers _
  //-- prints:
  // genesio@server.com.br
  // baltazar@anotherserver.com.br
}
