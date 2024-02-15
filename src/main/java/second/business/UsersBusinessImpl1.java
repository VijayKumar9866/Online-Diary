package second.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import second.dao.UsersDaoInterface;
import second.entites.Users;

@Component("usersBusiness")
public class UsersBusinessImpl1 implements UsersBusinessInterface {

	@Autowired
	@Qualifier("usersDao")
	private UsersDaoInterface usersDaoInterface;
	
	@Override
	@Transactional(readOnly = false)
	public void save(Users user) {
		usersDaoInterface.save(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Users user) {
		// TODO Auto-generated method stub
		usersDaoInterface.update(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Users user) {
		// TODO Auto-generated method stub
		usersDaoInterface.delete(user);
	}

	@Override
	public Users get(int id) {
		// TODO Auto-generated method stub
		Users user=usersDaoInterface.get(id);
		return user;
	}

	@Override
	public List<Users> loadAll() {
		// TODO Auto-generated method stub
		List<Users> users=usersDaoInterface.loadAll();
		return users;
	}

	@Override
	public Users findByName(String username) {
		Users user=usersDaoInterface.findByName(username);
		return user;
	}

}
