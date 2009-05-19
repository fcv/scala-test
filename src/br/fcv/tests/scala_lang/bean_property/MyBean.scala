package br.fcv.tests.scala_lang.bean_property

import scala.reflect.{BeanProperty => Prop}
import java.util.Date

class MyBean(@Prop var name: String, @Prop var birthdate: Date) {
}