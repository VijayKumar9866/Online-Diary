package second.business;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import second.dao.EntriesDaoInterface;
import second.entites.Entries;

@Component("entriesBusiness")
public class EntriesBusinessImpl1 implements EntriesBusinessInterface {

	@Autowired
	@Qualifier("entriesDao")
	public EntriesDaoInterface entriesDao;
	
	@Override
	@Transactional(readOnly = false)
	public void save(Entries entries) {
		// TODO Auto-generated method stub
		entriesDao.save(entries);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Entries entries) {
		entriesDao.update(entries);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Entries entries) {
		// TODO Auto-generated method stub
		entriesDao.delete(entries);
	}

	@Override
	public Entries get(int id) {
		
		Entries entry=entriesDao.get(id);
		
		return entry;
	}

	@Override
	public List<Entries> loadAll() {
		
		List<Entries> entries=entriesDao.loadAll();		
		return entries;
	}

	@Override
	@Transactional(readOnly = false)
	public List<Entries> findByUserId(int id) {
		List<Entries> entries=entriesDao.findByUserId(id);
		return entries;
	}

}
