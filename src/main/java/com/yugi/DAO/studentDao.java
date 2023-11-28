package com.yugi.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yugi.Api.hibernateConfig;
import com.yugi.hibernateEntity.students;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class studentDao {
	@Autowired
	private hibernateConfig hibernate;
	private Session session;

	public students getStudent(int id) {
		session = hibernate.createSession();
		session.beginTransaction();
		students student = session.get(students.class, id);
		session.getTransaction().commit();
		session.close();
		return student;
	}

	public List<students> getstudentList() {
		session = hibernate.createSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<students> criteria = builder.createQuery(students.class);
		criteria.from(students.class);
		List<students> student = session.createQuery(criteria).getResultList();
		session.getTransaction().commit();
		session.close();
		return student;
	}

	public void saveStudent(students student) {
		session = hibernate.createSession();
		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();
		session.close();

	}

	public void updateStudent(students student) {
		session = hibernate.createSession();
		session.beginTransaction();
		session.merge(student);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteStudent(students student) {
		session = hibernate.createSession();
		session.beginTransaction();
		session.remove(student);
		session.getTransaction().commit();
		session.close();
	}

	public boolean isPresentInDB(String studentname) {
		boolean has = false;
		session = hibernate.createSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<students> query = builder.createQuery(students.class);
		Root<students> root = query.from(students.class);
		Predicate statement = builder.equal(root.get("name"), studentname);
		query.where(statement);
		Query<students> result_set = session.createQuery(query);
		List<students> student_list = result_set.list();
		session.getTransaction().commit();
		session.close();
		System.out.println(student_list);
		if (!student_list.isEmpty())
			has = true;
		return has;
	}
}
