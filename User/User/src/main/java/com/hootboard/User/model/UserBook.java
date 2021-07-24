package com.hootboard.User.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class UserBook {
	
	@Id
	private Long userid;
	private String fullName;
	@ElementCollection 
	private Set<Long> friendList;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Set<Long> getFriendList() {
		return friendList;
	}
	public void setFriendList(Set<Long> friendList) {
		this.friendList = friendList;
	}
	
	public int validate()
	{
		try {
			this.getUserid();
			return 1;
		}
		catch(Exception e)
		{
			return -1;
		}
	}
	
	
	
	
	

}
