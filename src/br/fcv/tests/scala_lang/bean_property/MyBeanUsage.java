package br.fcv.tests.scala_lang.bean_property;

import java.util.Date;

public class MyBeanUsage {

	public static void main(String[] args) {
		MyBean mb = new MyBean("name", new Date());
		System.out.println(mb.getName());
	}
}
