package com.bway.springproject.daos;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bway.springproject.models.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void signup(User user) {
		Session session= sessionFactory.getCurrentSession();
		session.save(user);		
	}
@Transactional
	@Override
	public boolean login(String un, String psw) {
	Session sess= sessionFactory.getCurrentSession();
    Criteria crt=sess.createCriteria(User.class);
    crt.add(Restrictions.eq("username",un)).add(Restrictions.eq("password",psw));
    
    User u=(User)crt.uniqueResult();
    if(u!=null) {
    	return true;
    	
    } else {
    
	// TODO Auto-generated method stub
	return false;
    }
}
    
}
