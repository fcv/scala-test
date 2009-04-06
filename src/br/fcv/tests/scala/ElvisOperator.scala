package br.fcv.tests.scala

object ElvisOperator extends Application {
  
  object ElvisImpl {
    implicit def addElvisOperator[T](alt: T) = new {
      def ?: [P >: T] (pred: P) { 
        //if (pred == null) alt else pred
        "teste"
      }
    }
  }
  
  
  
  import ElvisImpl.addElvisOperator 
  
  var str = null;
  println("str: " + (str ?: "test"))
  
  println
  
  // -- ADVANCED USE ... more about SafeNavigation operator
  
  class Company(var name: String) {    
  }
  
  class Employee(var name: String, var company: Company) {
  }
  
  var fullEmp = new Employee("full emp", new Company("GM"));
  var empNoCompany = new Employee("no comp", null);
  var empCompNoName = new Employee("no comp name", new Company(null))
  
  // -- TODO: Think how to implement something like:
  // employee?.company?.name : "defaltCompanyName"
  //  println(empNoCompany.company.name)

}
