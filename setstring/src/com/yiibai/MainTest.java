package com.yiibai;

import java.util.ArrayList;
import java.util.HashSet;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;

public class MainTest {
	public static void main(String[] args) {
		// 在5.1.0版本中，hibernate则采用如下新方式获取：
		// 1. 配置类型安全的准服务注册类，这是当前应用的单例对象，不作修改，所以声明为final
		// 在configure("cfg/hibernate.cfg.xml")方法中，如果不指定资源路径，默认在类路径下寻找名为hibernate.cfg.xml的文件
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();
		// 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
		SessionFactory sessionFactory = new MetadataSources(registry)
				.buildMetadata().buildSessionFactory();

		/**** 上面是配置准备，下面开始我们的数据库操作 ******/
		Session session = sessionFactory.openSession();// 从会话工厂获取一个session

		// creating transaction object
		Transaction t = session.beginTransaction();

		HashSet<String> set1=new HashSet<String>();
		set1.add("java is a programming language");
		set1.add("java is a platform");
		
		HashSet<String> set2=new HashSet<String>();
		set2.add("Servlet is an Interface");
		set2.add("Servlet is an API");
		
		Question question1=new Question();
		question1.setQname("What is Java?");
		question1.setAnswers(set1);
		
		Question question2=new Question();
		question2.setQname("What is Servlet?");
		question2.setAnswers(set2);
		
		session.persist(question1);
		session.persist(question2);
		
		t.commit();
		session.close();
		System.out.println("success");

	}
}
