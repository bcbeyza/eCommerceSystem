package eCommerceSystems.dataAccess.abstracts;

import java.util.List;

import eCommerceSystems.entities.concretes.User;

public interface UserDao {

	
	void add(User user);
	void update(User user);
	void delete(User user);
	List<User>getAll();
	boolean getEmail(String email);
	boolean getPassword(String password);
}
