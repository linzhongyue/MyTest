package com.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;

/**用户服务接口实现
 * @author yudy
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public void removeUser(Long id) {
		userDao.delete(id);
	}

	@Override
	public void removeUsersInBatch(List<User> users) {
		userDao.deleteInBatch(users);
	}

	@Override
	public User updateUser(User user) {
		return userDao.saveAndFlush(user);
	}

	@Override
	public User getUserById(Long id) {
		return userDao.findOne(id);
	}

	@Override
	public List<User> listUsers() {
		return userDao.findAll();
	}

	@Override
	public Page<User> listUsersByNameLike(String name, Pageable pageable) {
		name = "%" + name + "%";
		Page<User> users = userDao.findByNameLike(name, pageable);
		return users;
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.findByUsername(username);
	}

}
