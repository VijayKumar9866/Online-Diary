package second.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import second.entites.Users;

@Component("usersDao")
public class UsersDaoImpl1 implements UsersDaoInterface {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional(readOnly = false)
	public void save(Users user) {
		hibernateTemplate.save(user);
	}

	@Transactional(readOnly = false)
	public void update(Users user) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(user);
	}

	@Transactional(readOnly = false)
	public void delete(Users user) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(user);
	}

	@Override
	public Users get(int id) {
		Users user=hibernateTemplate.get(Users.class,id);
		return user;
	}

	@Override
	public List<Users> loadAll() {
		List<Users> users=hibernateTemplate.loadAll(Users.class);
		return users;
	}

	@Override
	public Users findByName(String username1) {
		
		DetachedCriteria criteria=DetachedCriteria.forClass(Users.class);
		
		criteria.add(Restrictions.eq("username", username1));
		
		Users user=null;
	
		try {
			user=(Users)hibernateTemplate.findByCriteria(criteria).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

}
