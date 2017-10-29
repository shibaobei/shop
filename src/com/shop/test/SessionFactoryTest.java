package com.shop.test;


import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class SessionFactoryTest{
	public static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	public static void main(String[] args){
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate  = (HibernateTemplate) context.getBean("hibernateTemplate");


	}
}
