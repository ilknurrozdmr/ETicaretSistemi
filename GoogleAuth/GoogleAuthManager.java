package GoogleAuth;

import Entities.concretes.User;

public class GoogleAuthManager {

	public void register(User user) {
		System.out.println("Sayýn "+user.getName()+" "+user.getSurname()+" Google hesabýnýz ile üye oldunuz.");
	}
	public void login(User user) {
		System.out.println("Sayýn "+user.getName()+" "+user.getSurname()+" Google hesabýnýz ile giriþ yaptýnýz.");
	}
	
}
