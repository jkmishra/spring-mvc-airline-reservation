package com.gamma.air.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gamma.air.model.Account;
import com.gamma.air.repository.GammaDao;


@Transactional
public class GammaDaoImpl implements GammaDao {

	private Logger logger = LoggerFactory.getLogger(GammaDaoImpl.class);
	private static final String NAMESPACE = "location.";
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Account> listAccount() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Account> accountList=session.createQuery("from Account").list();
		for(Account p : accountList){
			logger.info("accountList::"+p);
		}
		
		return accountList;
	}


}
