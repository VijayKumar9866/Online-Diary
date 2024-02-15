package second.dao;

import java.util.List;

import second.entites.Users;



public interface UsersDaoInterface {
	
	void save(Users user);
	void update(Users user);
	void delete(Users user);
	Users get(int id);
	List<Users> loadAll();
	Users findByName(String username);
}
