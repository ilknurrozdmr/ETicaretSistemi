package AppleAuth;

import Entities.concretes.User;

public class AppleAuthManager {

	public void register(User user) {
		System.out.println("Say�n "+user.getName()+" "+user.getSurname()+" Apple hesab�n�z ile �ye oldunuz.");
	}
	public void login(User user) {
		System.out.println("Say�n "+user.getName()+" "+user.getSurname()+" Apple hesab�n�z ile giri� yapt�n�z.");
	}
}
