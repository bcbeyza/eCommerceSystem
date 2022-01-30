package eCommerceSystems.business.concretes;

import eCommerceSystems.business.abstracts.UserCheckService;
import eCommerceSystems.business.abstracts.UserService;
import eCommerceSystems.business.abstracts.VerificationService;
import eCommerceSystems.core.GoogleService;
import eCommerceSystems.dataAccess.abstracts.UserDao;
import eCommerceSystems.entities.concretes.User;

public class UserManager implements UserService {

	
	private UserDao userDao;
	private VerificationService verificationService;
	private UserCheckService userCheckService;
	private GoogleService googleService;
	
	public UserManager(UserDao userDao, VerificationService verificationService, UserCheckService userCheckService,GoogleService googleService) {
		super();
		this.userDao = userDao;
		this.verificationService = verificationService;
		this.userCheckService = userCheckService;
		this.googleService=googleService;
	}

	@Override
	public void signIn(User user) {
		
		if(userCheckService.isValid(user)==true) {
			System.out.println("Kullanici basariyla sisteme eklendi: "+ user.getFirstName());
			verificationService.sendToVerifyMail(user.getEmail());
			userDao.add(user);
			googleService.signUpToSystem("Kullanici google hesabi ile kayit oldu:");
		}
		
		
		
	}

	@Override
	public void signUp(User user) {
		
		verificationService.verifyMail(user.getEmail());
		if(userDao.getEmail(user.getEmail())&& userDao.getPassword(user.getPassword())&& verificationService.checkVerifyAccount(user.getEmail())==true) {
			System.out.println("Kullanici girisi basariyla yapildi.");
			
		}
		else if(verificationService.checkVerifyAccount(user.getEmail())==false) {
			System.out.println("Mail adresi dogrulanmadigi için giris basarisiz.");
		}
		else {
			System.out.println("Kullanici bilgileri yanlis");
		}
		
		
	}

}
