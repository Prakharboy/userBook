package com.hootboard.User.repository;

import org.springframework.data.repository.CrudRepository;

import com.hootboard.User.model.UserBook;

public interface UserbookRepository extends CrudRepository<UserBook,Long> {

}
