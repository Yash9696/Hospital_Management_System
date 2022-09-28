package com.app.spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.daos.IUserDao;
import com.app.entities.User;
import com.app.services.UserServices;
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	IUserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			User user = userDao.findByEmail(email);
			if(user!=null) {
				return user;
			}
		
		return null;
	}

}
