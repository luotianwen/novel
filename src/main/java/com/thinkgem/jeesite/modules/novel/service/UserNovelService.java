/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.novel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.novel.entity.UserNovel;
import com.thinkgem.jeesite.modules.novel.dao.UserNovelDao;

/**
 * 用户阅读小说Service
 * @author 用户阅读小说
 * @version 2021-02-19
 */
@Service
@Transactional(readOnly = true)
public class UserNovelService extends CrudService<UserNovelDao, UserNovel> {

	public UserNovel get(String id) {
		return super.get(id);
	}
	
	public List<UserNovel> findList(UserNovel userNovel) {
		return super.findList(userNovel);
	}
	
	public Page<UserNovel> findPage(Page<UserNovel> page, UserNovel userNovel) {
		return super.findPage(page, userNovel);
	}
	
	@Transactional(readOnly = false)
	public void save(UserNovel userNovel) {
		super.save(userNovel);
	}
	
	@Transactional(readOnly = false)
	public void delete(UserNovel userNovel) {
		super.delete(userNovel);
	}
	
}