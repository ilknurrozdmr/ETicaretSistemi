package AppleAuth;

import Entities.concretes.User;

public class AppleAuthManager {

	public void register(User user) {
		System.out.println("Sayýn "+user.getName()+" "+user.getSurname()+" Apple hesabýnýz ile üye oldunuz.");
	}
	public void login(User user) {
		System.out.println("Sayýn "+user.getName()+" "+user.getSurname()+" Apple hesabýnýz ile giriþ yaptýnýz.");
	}
}
