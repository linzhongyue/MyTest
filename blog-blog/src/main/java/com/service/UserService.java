package com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.entity.User;

/**用户服务接口
 * @author yudy
 *
 */
public interface UserService {
	
	/**根据用户账号查询
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	User saveUser(User user);
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	void removeUser(Long id);
	
	/**
	 * 删除列表里面的用户
	 * @param user
	 * @return
	 */
	void removeUsersInBatch(List<User> users);
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	User updateUser(User user);
	
	/**
	 * 根据id获取用户
	 * @param user
	 * @return
	 */
	User getUserById(Long id);
	
	/**
	 * 获取用户列表
	 * @param user
	 * @return
	 */
	List<User> listUsers();
	
	/**
	 * 根据用户名进行分页模糊查询
	 * @param user
	 * @return
	 */
	Page<User> listUsersByNameLike(String name, Pageable pageable);
	
	
}
