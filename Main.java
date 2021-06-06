import AppleAuth.AppleAuthManager;
import Business.abstracts.UserService;
import Business.concretes.UserManager;
import Core.AppleAuthManagerAdapter;
import Core.GoogleAuthManagerAdapter;
import DataAccess.concretes.HiberNetUserDao;
import Entities.concretes.User;
import GoogleAuth.GoogleAuthManager;

public class Main {

	public static void main(String[] args) {
		
		UserService userService=new UserManager(new HiberNetUserDao(), new GoogleAuthManagerAdapter(new GoogleAuthManager()));
		User user1=new User("Ýlknur", "Özdemir","io@gmail.com","123456",true);
		User user2=new User("Tuðçe", "Gür","tg@gmail.com","987654",true);
		userService.register(user1);
		userService.login(user1);
		userService.confirm(user1);
		userService.registerWithAccount(user2);
		userService.loginWithAccount(user2);
		
		
	}

}
