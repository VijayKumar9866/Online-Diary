package second.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import second.entites.Entries;

@Component("entriesDao")
public class EntriesDaoImpl1 implements EntriesDaoInterface {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	@Transactional(readOnly = false)
	public void save(Entries entrie) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(entrie);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Entries entrie) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(entrie);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(Entries entrie) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(entrie);
	}

	@Override
	@Transactional(readOnly=false)
	public Entries get(int id) {
		// TODO Auto-generated method stub
		Entries entrie=hibernateTemplate.get(Entries.class,id);
		return entrie;
	}

	@Override
	public List<Entries> loadAll() {
		// TODO Auto-generated method stub
		List<Entries> entries=hibernateTemplate.loadAll(Entries.class);
		return entries;
	}


	@Override
	@Transactional(readOnly=false)
	public List<Entries> findByUserId(int id) {
		
		DetachedCriteria criteria=DetachedCriteria.forClass(Entries.class);
		
		criteria.add(Restrictions.eq("userid",id));
		
		List<Entries> entries=null;
		
		try {
			entries=(List<Entries>)hibernateTemplate.findByCriteria(criteria);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			return entries;
		}
		
		
		return entries;
	}
	
}
