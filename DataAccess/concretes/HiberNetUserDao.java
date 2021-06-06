package DataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

public class HiberNetUserDao implements UserDao {
	
	List<User> users=new ArrayList<User>();

	@Override
	public void register(User user) {
		System.out.println(user.getName()+" isimli kullanýcýnýn kaydý tamamlanmýþtýr");
		users.add(user);
		
	}

	@Override
	public void login(User user) {
		System.out.println(user.getName()+" isimli kullanýcý giriþ yaptý.");
		
	}

	@Override
	public void confirm(User user) {
		System.out.println(user.getEmail()+" e-mail adresiniz onaylanmýþtýr.");
		user.setVerify(true);
	}

	@Override
	public List<User> getAll() {
		return this.users;
	}

}
