package eCommerceSystems.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import eCommerceSystems.business.abstracts.UserCheckService;
import eCommerceSystems.entities.concretes.User;

public class UserCheckManager implements UserCheckService{

	
	List<String>listOfEmails=new ArrayList<String>();
	
	
	
	@Override
	public boolean checkFirstName(User user) {
		if(user.getFirstName().isEmpty()) {
			System.out.println("Ýsim alani bos birakilamaz.Lutfen doldurunuz.");
			return false;
		}
		else if (user.getFirstName().length()<2) {
			System.out.println("Ýsim bolumu en az iki karakterden olusmalýdýr.");
			return false;	
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		if(user.getLastName().isEmpty()) {
			System.out.println("Soysisim alani bos birakilamaz.Lutfen doldurunuz.");
			return false;
		}
		else if (user.getLastName().length()<2) {
			System.out.println("Soyisim bolumu en az iki karakterden olusmalýdýr.");
			return false;	
		}
		return true;
	}

	@Override
	public boolean checkEmail(User user) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		
		if(user.getEmail().isEmpty()) {
			System.out.println("Email kismi bos birakilamaz !");
			return false;
		}
		else if(pattern.matcher(user.getFirstName()).find()==false) {
			System.out.println("Girilen email adresi uygun formatta degil !");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPassword(User user) {
		
		if(user.getPassword().isEmpty()) {
			System.out.println("Sifre kismi bos birakilamaz !");
			return false;
		}
		else if(user.getPassword().length()<5) {
			System.out.println("Sifre en az 6 karakterden olusmali! ");
			return false;
		}
		return true;
	}

	@Override
	public boolean uniqueEmail(User user) {
		
		if(listOfEmails.contains(user.getEmail())) {
			System.out.println("Bu mail adresi ile sisteme daha once kayýt olunmus.Lutfen farklý bir mail adresi deneyiniz !");
			return false;
		}
		else {
			listOfEmails.add(user.getEmail());
			return true;
		}
		
	}

	@Override
	public boolean isValid(User user) {
		if(checkFirstName(user) && checkEmail(user) && checkLastName(user)&& checkPassword(user)&& uniqueEmail(user)==true) {
			return true;
		}
		return false;
	}

}
