package second.business;

import java.util.List;

import second.entites.Entries;



public interface EntriesBusinessInterface {

	void save(Entries entries);
	void update(Entries entries);
	void delete(Entries entries);
	Entries get(int id);
	List<Entries> loadAll();
	List<Entries> findByUserId(int id);
}
