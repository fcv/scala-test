package br.fcv.tests.scala.bean_property

import _root_.scala.reflect.{BeanProperty => Prop}
import java.util.Date

class MyBean(@Prop var name: String, @Prop var birthdate: Date) {
}