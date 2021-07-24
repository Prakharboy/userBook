package com.hootboard.User.service;

import java.util.List;
import java.util.Set;

import com.hootboard.User.model.UserBook;

public interface UserBookservice {

	//post , post friend , get friends
	
	int postFriends(long userId,long userId2);  
	UserBook saveUser(UserBook user); //save
	Set<Long> getFriends(long userId1); //
	
	
	
}
