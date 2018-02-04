package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AuthorityDao;
import com.entity.Authority;
import com.service.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	public AuthorityDao authorityDao;
	@Override
	public Authority getAuthorityById(Long id) {
		return authorityDao.findOne(id);
	}
}
