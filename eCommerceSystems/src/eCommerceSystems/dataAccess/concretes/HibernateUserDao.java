package eCommerceSystems.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSystems.dataAccess.abstracts.UserDao;
import eCommerceSystems.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	
	List<User>users= new ArrayList<User>();
	@Override
	public void add(User user) {
		System.out.println("User is added: "+ user.getFirstName());
		
	}

	@Override
	public void update(User user) {
		
		System.out.println("User is updated: "+ user.getFirstName());
	}

	@Override
	public void delete(User user) {
		System.out.println("User is deleted: "+ user.getFirstName());
		
	}

	@Override
	public List<User> getAll() {
		
		return null;
	}

	@Override
	public boolean getEmail(String email) {
		for(User user: users) {
			if(user.getEmail()==email) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getPassword(String password) {
		for(User user: users) {
			if(user.getPassword()==password) {
				return true;
			}
		}
		return false;
	}

	
	

}
