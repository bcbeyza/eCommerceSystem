package eCommerceSystems.core;

import eCommerceSystems.jLogWithGoogleAccount.GoogleLoggerManager;

public class GoogleLoggerManagerAdapter implements GoogleService {

	@Override
	public void signUpToSystem(String message) {
		
		GoogleLoggerManager manager=new GoogleLoggerManager();
		manager.googleLogger(message);
		
	}

}
