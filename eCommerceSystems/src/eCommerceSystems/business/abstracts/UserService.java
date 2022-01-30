package eCommerceSystems.business.abstracts;

import eCommerceSystems.entities.concretes.User;

public interface UserService {

	
	void signIn(User user);
	void signUp(User user);
}
