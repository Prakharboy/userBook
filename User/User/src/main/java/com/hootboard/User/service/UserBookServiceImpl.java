package com.hootboard.User.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hootboard.User.model.UserBook;
import com.hootboard.User.repository.UserbookRepository;

@Service
public class UserBookServiceImpl implements UserBookservice {

	@Autowired
	UserbookRepository userBookRepository;
	@Override
	public int postFriends(long userId1,long userId2) {
		try {
			
			if(userBookRepository.findById(userId1).isPresent()&&userBookRepository.findById(userId2).isPresent())
			{
		Optional<UserBook> user = userBookRepository.findById(userId1);
		Set<Long> friendList= user.get().getFriendList();
		friendList.add(userId2);	
		user.get().setFriendList(friendList);
		userBookRepository.save(user.get());
			
		Optional<UserBook> user1 = userBookRepository.findById(userId2);
		Set<Long> friendList1= user1.get().getFriendList();
		friendList1.add(userId1);	
		user1.get().setFriendList(friendList1);
		userBookRepository.save(user1.get());
			}
			return 1;
			
		}
		catch(Exception e)
		{
			return -1;
		}
	}

	@Override
	public UserBook saveUser(UserBook user) {
		try {
			
			if(!userBookRepository.findById(user.getUserid()).isPresent())
			{
			UserBook savedUser= userBookRepository.save(user);
		return savedUser;
			}
			
		}
		catch(Exception e)
		{
			return null;
		}
		return null;

		
	}

	@Override
	public Set<Long> getFriends(long userId) {
		try {
			Optional<UserBook> user = userBookRepository.findById(userId);
			if(user.isPresent())
			return user.get().getFriendList();
		}
		catch(Exception e)
		{
			return null;
		}
		return null;
		
	}

}
