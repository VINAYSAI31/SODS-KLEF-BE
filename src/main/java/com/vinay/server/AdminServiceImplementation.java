package com.vinay.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.model.Admin;
import com.vinay.repository.AdminRepository;

@Service
public class AdminServiceImplementation implements AdminService{

	@Autowired
	private AdminRepository adminrepo;
	
	@Override
	public Admin checkadmin(String username,String password) {
		Admin admin= adminrepo.findByUsername(username);
		if(admin!=null && admin.getPassword().equals(password))
		{
			return admin;

		}
		else
		{
			return null;
		}
		
	}

	@Override
	public List<Admin> getalladmins() {
		// TODO Auto-generated method stub
		return adminrepo.findAll();
	}

	@Override
	public void addadmin(Admin admin) {
		// TODO Auto-generated method stub
		adminrepo.save(admin);
	}

	@Override
	public void deleteadmin(int id) {
		// TODO Auto-generated method s;
		adminrepo.deleteById(id);
		
		
	}

}
	
