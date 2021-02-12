package com.java.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.entity.Addcard;
import com.java.entity.Stock;
import com.java.entity.User;
@Repository
public class dao {
	@Autowired
	SessionFactory sessionfactory;
Stock stock;

	public boolean checklogin(User user) {
		System.out.println("11");
		String username=user.getUsername();
		System.out.println("555");
		String password=user.getPassword();
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username",username));
		System.out.println("999");
		criteria.add(Restrictions.eq("password",password));
		List<User> listuser=criteria.list();
		if(!listuser.isEmpty())
		{
			System.out.println("0000");
			return true;
		}
		else
		{
			System.out.println("444");
			return false;
		}
	}


	public List<Stock> getstock() {
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Stock.class);
		List<Stock>liststock=criteria.list();
			return liststock;
	}


	public boolean addmed(Stock stock) {
		Session session=sessionfactory.openSession();
		org.hibernate.Transaction transaction=session.beginTransaction();
		
		session.save(stock);
		transaction.commit();
		
		return true;
	}


	public boolean deletestock(int stid) {
		Session session=sessionfactory.openSession();
		org.hibernate.Transaction transcation=session.beginTransaction();
		Stock stock=session.get(Stock.class, stid);
		session.delete(stock);
		//session.delete("id",userid);
		transcation.commit();
		
		return true;
	}


	public List<Addcard> getcard() {
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Addcard.class);
		List<Addcard>liststock=criteria.list();
			return liststock;
	}


	public boolean addcard(Addcard card) {
		Session session=sessionfactory.openSession();
		org.hibernate.Transaction transaction=session.beginTransaction();
		session.save(card);
		
		transaction.commit();
		/*String quantity2=card.getQuantity();
		System.out.println(quantity2);
		int quantity1=stock.getQuantity();
		System.out.println(quantity1);
		*/
		return true;
	}

}
