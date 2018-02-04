package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dao.BlogDao;
import com.entity.Blog;
import com.entity.User;
import com.service.BlogService;
@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogDao blogDao;
	
	@Override
	public Blog saveBlog(Blog blog) {
		return blogDao.save(blog);
	}

	@Override
	public void removeBlog(Long id) {
		blogDao.delete(id);
	}

	@Override
	public Blog updateBlog(Blog blog) {
		return blogDao.save(blog);
	}

	@Override
	public Blog getBlogById(Long id) {
		return blogDao.findOne(id);
	}

	@Override
	public Page<Blog> listBlogsByTitleLike(User user, String title, Pageable pageable) {
		title = "%" + title + "%";
		Page<Blog> blogs = blogDao.findByUserAndTitleLikeOrderByCreateTimeDesc(user, title, pageable);
		return blogs;
	}

	@Override
	public Page<Blog> listBlogsByTitleLikeAndSort(User suser, String title, Pageable pageable) {
		title = "%" + title + "%";
		Page<Blog> blogs = blogDao.findByUserAndTitleLike(suser, title, pageable);
		return blogs;
	}

	@Override
	public void readingIncrease(Long id) {
		Blog blog = blogDao.findOne(id);
		blog.setReading(blog.getReading()+1);
		blogDao.save(blog);
	}

}
