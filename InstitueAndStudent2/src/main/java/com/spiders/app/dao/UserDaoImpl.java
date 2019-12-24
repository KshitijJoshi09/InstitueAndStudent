package com.spiders.app.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spiders.app.dto.Address;
import com.spiders.app.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDaoI {

	@PostConstruct
	void init() {

		// for initilizing the data base

		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			UserDto admin1 = new UserDto();
			admin1.setAdminId(0);
			admin1.setAge(31);
			admin1.setDepartment("development");
			admin1.setRole("ADMIN");
			admin1.setFirstName("kiran");
			admin1.setLastName("kaur");
			admin1.setEmail("kiran@gamil.com");
			admin1.setPassword("admin");
			admin1.setUserName("kiran123");
			admin1.setAddress(new Address("ludhaina", "5 street", "141001", "punjab"));
			admin1.setMobileNo("9988779988");

			UserDto admin2 = new UserDto();
			admin2.setAdminId(0);
			admin2.setAge(28);
			admin2.setDepartment("testing");
			admin2.setRole("ADMIN");
			admin2.setFirstName("ram");
			admin2.setLastName("kumar");
			admin2.setEmail("ram123@gamil.com");
			admin2.setPassword("admin");
			admin2.setUserName("ram123");
			admin2.setAddress(new Address("kullu", "10 street", "211101", "himachal"));
			admin2.setMobileNo("9900779900");

			UserDto user1 = new UserDto();
			user1.setAdminId(1);
			user1.setAge(20);
			user1.setDepartment("development");
			user1.setRole("USER");
			user1.setFirstName("kallu");
			user1.setLastName("preet");
			user1.setEmail("kallu@gamil.com");
			user1.setPassword("user");
			user1.setUserName("kallu123");
			user1.setAddress(new Address("bihar", "11 street", "299101", "bihar"));
			user1.setMobileNo("9900112211");

			UserDto user2 = new UserDto();
			user2.setAdminId(1);
			user2.setAge(18);
			user2.setDepartment("development");
			user2.setRole("USER");
			user2.setFirstName("hira");
			user2.setLastName("sharma");
			user2.setEmail("hira3@gamil.com");
			user2.setPassword("admin");
			user2.setUserName("hira3");
			user2.setAddress(new Address("ajmeer", "1 street", "911101", "Rajasthan"));
			user2.setMobileNo("9900779999");

			UserDto user3 = new UserDto();
			user3.setAdminId(2);
			user3.setAge(28);
			user3.setDepartment("testing");
			user3.setRole("USER");
			user3.setFirstName("hement");
			user3.setLastName("kumar");
			user3.setEmail("hement13@gamil.com");
			user3.setPassword("user");
			user3.setUserName("hem321");
			user3.setAddress(new Address("kullu", "10 street", "211101", "himachal"));
			user3.setMobileNo("5500779900");
			
			UserDto user4 = new UserDto();
			user4.setAdminId(2);
			user4.setAge(22);
			user4.setDepartment("testing");
			user4.setRole("USER");
			user4.setFirstName("manoj");
			user4.setLastName("jain");
			user4.setEmail("jain@gamil.com");
			user4.setPassword("user");
			user4.setUserName("jain321");
			user4.setAddress(new Address("kullu", "10 street", "211101", "himachal"));
			user4.setMobileNo("9912379900");

			int dbDate = session.createQuery("from UserDto").list().size();

			if (dbDate <= 0) {
				session.save(admin1);
				session.save(admin2);
				session.save(user1);
				session.save(user2);
				session.save(user3);
				session.save(user4);
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

	}

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable saveUser(UserDto user) {

		Serializable id = 0;
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			id = session.save(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return id;
	}

	@Override
	public void updateUser(UserDto user) {
		Serializable id = 0;
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			// find user by id and update user
			UserDto userFromDb = session.get(UserDto.class, user.getUserId());

			userFromDb.setAddress(user.getAddress());

			session.update(userFromDb);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

	@Override
	public void delete(UserDto user) {

		Serializable id = 0;
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			UserDto userfromDb = session.get(UserDto.class, user.getUserId());
			session.delete(userfromDb);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

	}

	@Override
	public UserDto findUser(String loginId) {
		UserDto userFromDb = null;
		try (Session session = sessionFactory.openSession()) {
			// find by email
			Query<UserDto> query = session.createQuery("from UserDto where email = :loginId ");
			query.setParameter("loginId", loginId);
			userFromDb = query.uniqueResult();

			if (userFromDb == null) {// find by mobile no
				query = session.createQuery("from UserDto where mobileNo = :loginId ");
				query.setParameter("loginId", loginId);
				userFromDb = query.uniqueResult();

			}
			if (userFromDb == null) {// find by user name
				query = session.createQuery("from UserDto where userName = :loginId ");
				query.setParameter("loginId", loginId);
				userFromDb = query.uniqueResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userFromDb;
	}

	@Override
	public UserDto findUser(long userId) {
		UserDto userfromDb = null;

		try (Session session = sessionFactory.openSession()) {
			userfromDb = session.get(UserDto.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userfromDb;
	}

	@Override
	public List<UserDto> findAllUserByAdminId(long adminId) {
		List<UserDto> allUser = null;
		try (Session session = sessionFactory.openSession()) {
			// find by amdin id
			Query<UserDto> query = session.createQuery("from UserDto where adminId = :adminId ");
			query.setParameter("adminId", adminId);
			allUser = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allUser;
	}

}
