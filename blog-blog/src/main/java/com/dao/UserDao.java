package com.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.User;

public interface UserDao extends JpaRepository<User,Long>{
	/**
	 * 根据用户名分页查询用户列表
	 * @param name
	 * @param pageable
	 * @return
	 */
	Page<User> findByNameLike(String name, Pageable pageable);
	
	/**根据用户账号查询
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
}
