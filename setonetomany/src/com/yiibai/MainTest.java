package com.yiibai;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;

public class MainTest {
	public static void main(String[] args) {
		// ��5.1.0�汾���ܣ�hibernate����������·�ʽ��ȡ��
		// 1. �������Ͱ�ȫ��׼����ע���࣬���ǵ�ǰӦ�õĵ������󣬲����޸ģ���������Ϊfinal
		// ��configure("cfg/hibernate.cfg.xml")�����У������ָ����Դ·����Ĭ������·����Ѱ����Ϊhibernate.cfg.xml���ļ�
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();
		// 2. ���ݷ���ע���ഴ��һ��Ԫ������Դ����ͬʱ����Ԫ���ݲ�����Ӧ��һ��Ψһ�ĵ�session����
		SessionFactory sessionFactory = new MetadataSources(registry)
				.buildMetadata().buildSessionFactory();

		/**** ����������׼�������濪ʼ���ǵ����ݿ���� ******/
		Session session = sessionFactory.openSession();// �ӻỰ������ȡһ��session

		// creating transaction object
		Transaction t = session.beginTransaction();

		Question question1 = new Question();
		question1.setQname("What is Java?");
		session.save(question1);
		
		Answer ans1 = new Answer();
		ans1.setAnswername("java is a programming language");
		ans1.setPostedBy("Ravi Su");
		ans1.setQuestion(question1);
		//question1.getAnswers().add(ans1);
		
		session.save(ans1);
		
		Answer ans2 = new Answer();
		ans2.setAnswername("java is a platform");
		ans2.setPostedBy("Sudhir Lee");
		ans2.setQuestion(question1);
		session.save(ans2);
		
		t.commit();
		session.close();
		
		System.out.println("success");

	}
}
