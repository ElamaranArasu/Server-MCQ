package com.ela.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ela.User;
import com.ela.Dto.Authenticated;
import com.ela.Dto.login;
import com.ela.repo.UserRepo;

@Service
public class PSService {
	@Autowired
	UserRepo usRepo;
	
	
	public Authenticated autentication(login lg)
	{
		Authenticated au=new Authenticated();
		User us=new User();
		String un=lg.getUserName();
		us=usRepo.findByName(un);
		if(us!=null) {
			if(us.getPassword().equals(lg.getPassword())) {
				au.setUserID(us.getUserID());
				String token="QSDRTBFF";
				au.setToken(token);
				us.setToken(token);
				usRepo.save(us);
				//System.out.println("token   "+au.getToken());
				return au;
			}
		}
		System.out.println("failed");
		return au;
	}
	
	public boolean signupService(User us) {
		if(us!=null) {
			usRepo.save(us);
			return true;
		}
		return false;
	}
	
	public boolean isAuthentic(Authenticated au ) {
		User us=new User();
		if(au!=null) {
			System.out.println(au.getUserID());
			System.out.println(au.getToken());
			if(usRepo.existsById(au.getUserID())) {
				System.out.println("2");
				us=usRepo.findById(au.getUserID()).orElse(null);
				if(us.getToken()!=null) {
					if(us.getToken().equals(au.getToken())) {
						
						return true;
					}
					else return false;
				}
				else return false;
			}
			else return false;
		}
		return false;
	}
}
