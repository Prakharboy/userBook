package com.hootboard.User.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hootboard.User.model.FriendPair;
import com.hootboard.User.model.UserBook;
import com.hootboard.User.model.UserInfo;
import com.hootboard.User.service.UserBookservice;

@RestController
public class UserBookController {
	
	
	
	
	@Autowired  
	UserBookservice service;
	
	
	@PostMapping("/saveUserBook")  
	private UserBook saveUser(@RequestBody UserBook user)   
	{  //request validation here
		if(user.validate()>0)
		return service.saveUser(user); 
		else
			return null;
	 
	}  

	@PutMapping("/updateFriendList")  
	private int updateFriendList(@RequestBody FriendPair friendPair )   
	{  int result;
		if(friendPair.validate()>0)
		result = service.postFriends(friendPair.getUserId1(),friendPair.getUserId2());
	else
		return -1;
		if(result==1)
	return 1;  
		else
			return -1;
	} 

	
	
	@GetMapping("/getFriendList/{userId}")  
	private Set<Long> getAllFriends(@PathVariable("userId") Long userId)   
	{  
	return service.getFriends(userId);  
	} 

}
