package com.yugi.Api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.yugi.hibernateEntity.students;

@Service
public class hibernateConfigImpl implements hibernateConfig {
	private static Session session = null;

	private static SessionFactory createFactory() {
		SessionFactory sf = new Configuration().addAnnotatedClass(students.class).configure("configuration.cfg.xml")
				.buildSessionFactory();
		return sf;
	}

	private static Session checkSession() {
		SessionFactory sf = createFactory();
		if (session == null) {
			session = sf.openSession();
		} else if (!session.isOpen()) {
			session = sf.openSession();
		}
		return session;

	}

	@Override
	public Session createSession() {
		return checkSession();
	}

}
