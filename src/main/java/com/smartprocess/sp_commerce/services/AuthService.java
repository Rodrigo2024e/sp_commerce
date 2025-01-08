

package com.smartprocess.sp_commerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartprocess.sp_commerce.entities.User;
import com.smartprocess.sp_commerce.services.exceptions.ForbiddenException;

@Service
public class AuthService {

	@Autowired 
	private UserService userService;
	
	public void validateSelfOrAdmin(long userId) {
		User me =  userService.authenticated();
		if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
			throw new ForbiddenException("Acess denied");
		}
	}
}