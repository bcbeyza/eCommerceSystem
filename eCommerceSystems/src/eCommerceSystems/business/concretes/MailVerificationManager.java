package eCommerceSystems.business.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSystems.business.abstracts.VerificationService;

public class MailVerificationManager implements VerificationService {

	
	List<String> verificatedEmails=new ArrayList<String>();
	
	@Override
	public void sendToVerifyMail(String email) {
		
		System.out.println(email + ": kullaniciya dogrulama emaili gonderildi.");
	}

	@Override
	public void verifyMail(String email) {
		verificatedEmails.add(email);
		System.out.println("Mail basarili bir sekilde dogrulandi.");
		
	}

	@Override
	public boolean checkVerifyAccount(String email) {
		
		if(verificatedEmails.contains(email)) {
			return true;
		}
		return false;
	}

}
