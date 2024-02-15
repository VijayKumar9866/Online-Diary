package second.dao;

import java.util.List;

import second.entites.Entries;



public interface EntriesDaoInterface {

	void save(Entries entrie);
	void delete(Entries entrie);
	void update(Entries entrie);
	Entries get(int id);
	List<Entries> loadAll();
	List<Entries> findByUserId(int id);
}
