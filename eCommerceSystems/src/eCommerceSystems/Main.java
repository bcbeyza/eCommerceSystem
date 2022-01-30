package eCommerceSystems;

import eCommerceSystems.business.abstracts.UserService;
import eCommerceSystems.business.concretes.MailVerificationManager;
import eCommerceSystems.business.concretes.UserCheckManager;
import eCommerceSystems.business.concretes.UserManager;
import eCommerceSystems.core.GoogleLoggerManagerAdapter;
import eCommerceSystems.dataAccess.concretes.HibernateUserDao;
import eCommerceSystems.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
	User user=new User("Mina","Cetiner","minactn@gmail.com","11234389643");
	UserService userService=new UserManager(new HibernateUserDao(),new MailVerificationManager(),new UserCheckManager(),new GoogleLoggerManagerAdapter());
	userService.signUp(user);
		
		

	}
	

}
