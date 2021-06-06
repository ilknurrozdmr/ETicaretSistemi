package Business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Business.abstracts.UserService;
import Core.AuthService;
import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private AuthService authservice;

	public UserManager(UserDao userDao, AuthService authservice) {
		this.userDao = userDao;
		this.authservice = authservice;
	}

	@Override
	public void register(User user) {
		if(user.getPassword().length()<6) {
			System.out.println("Þifre en az 6 karakterden oluþmalýdýr.");
		}
		final String EMAIL_PATTERN="^[A-Za-z0-9+_.-]+@(.+)$";
		final Pattern pattern=Pattern.compile(EMAIL_PATTERN);
		Matcher matcher=pattern.matcher(EMAIL_PATTERN);
		
		if(!matcher.matches()) {
			System.out.println(user.getEmail()+ " E-posta giriþi baþarýlýdýr.");
		}
		else {
			System.out.println(user.getEmail()+ " E-posta formatýna uygun deðildir.");
		}
		for (User users:userDao.getAll()) {
			if(users.getEmail().equals(user.getEmail())) {
				System.out.println(user.getEmail()+" Bu e-posta adresi sistemde mevcuttur.");
			}
		}
		if(user.getName().length()<2 && user.getSurname().length()<2) {
			System.out.println("Ad ve Soyad en az iki karakterden oluþmalýdýr.");
		}
		
	}

	@Override
	public void login(User user) {
		if(user.isVerify()==true) {
			userDao.login(user);
		}
		else {
			System.out.println("Giriþ baþarýsýz. E-Postanýzý kontrol ediniz.");
		}
		
	}

	@Override
	public void confirm(User user) {
		
		if(user.isVerify()==true) {
		  userDao.confirm(user);
		  System.out.println("Sayýn "+user.getName()+" "+user.getSurname()+" E-posta adresiniz doðrulanmýþtýr.");
		}
		else {
			System.out.println("Sayýn "+user.getName()+" "+user.getSurname()+" E-posta adresiniz doðrulanmamýþtýr.");
		}
		
	}

	@Override
	public void registerWithAccount(User user) {
		
		user.setVerify(true);
		this.authservice.register(user);
		
	}

	@Override
	public void loginWithAccount(User user) {
		
		if(user.isVerify()==true) {
			this.authservice.login(user);
		}
		else {
			System.out.println("Henüz kayýt olunmamýþ.");
		}
		
	}


}
