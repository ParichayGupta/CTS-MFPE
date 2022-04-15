package com.cts.retailbank.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.cts.retailbank.auth.exception.AppUserNotFoundException;
import com.cts.retailbank.auth.model.AppUser;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class LoginService {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private CustomerDetailsService customerDetailservice;

	public AppUser userLogin(AppUser appuser) throws AppUserNotFoundException {
		final UserDetails userdetails = customerDetailservice.loadUserByUsername(appuser.getUserid());
		String userid = "";
//		String role="";
		String token = "";
		
		log.info("Password From DB-->{}" ,userdetails.getPassword());
		log.info("Password From Request-->{}", encoder.encode(appuser.getPassword()) );

		if (userdetails.getPassword().equals(appuser.getPassword()) ) {
			userid = appuser.getUserid();
//			role = userdetails.getAuthorities().toString();
//			role=role.substring(6, role.length()-1);
//			log.info("Role From DB-->{}" ,role);
			token = jwtutil.generateToken(userdetails);
			return new AppUser(userid, null, null, token);
		} else {
			throw new AppUserNotFoundException("Username/Password is incorrect...Please check");
		}
	}
}