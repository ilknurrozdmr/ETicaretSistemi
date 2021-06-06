package DataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

public class HiberNetUserDao implements UserDao {
	
	List<User> users=new ArrayList<User>();

	@Override
	public void register(User user) {
		System.out.println(user.getName()+" isimli kullan�c�n�n kayd� tamamlanm��t�r");
		users.add(user);
		
	}

	@Override
	public void login(User user) {
		System.out.println(user.getName()+" isimli kullan�c� giri� yapt�.");
		
	}

	@Override
	public void confirm(User user) {
		System.out.println(user.getEmail()+" e-mail adresiniz onaylanm��t�r.");
		user.setVerify(true);
	}

	@Override
	public List<User> getAll() {
		return this.users;
	}

}
