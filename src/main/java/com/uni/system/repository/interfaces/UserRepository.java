package com.uni.system.repository.interfaces;

import com.uni.system.model.User;

public interface UserRepository {
	
	User getUserbyUsername(String username);

}
