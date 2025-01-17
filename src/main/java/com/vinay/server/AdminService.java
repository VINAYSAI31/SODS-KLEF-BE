package com.vinay.server;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vinay.model.Admin;


@Service
public interface AdminService {

	public Admin checkadmin(String username,String password);

	List<Admin> getalladmins();

	void addadmin(Admin admin);

	void deleteadmin(int id);
}
