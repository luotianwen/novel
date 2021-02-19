/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.novel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.novel.entity.Nuser;
import com.thinkgem.jeesite.modules.novel.dao.NuserDao;

/**
 * 用户管理Service
 * @author 用户管理
 * @version 2021-02-19
 */
@Service
@Transactional(readOnly = true)
public class NuserService extends CrudService<NuserDao, Nuser> {

	public Nuser get(String id) {
		return super.get(id);
	}
	
	public List<Nuser> findList(Nuser nuser) {
		return super.findList(nuser);
	}
	
	public Page<Nuser> findPage(Page<Nuser> page, Nuser nuser) {
		return super.findPage(page, nuser);
	}
	
	@Transactional(readOnly = false)
	public void save(Nuser nuser) {
		super.save(nuser);
	}
	
	@Transactional(readOnly = false)
	public void delete(Nuser nuser) {
		super.delete(nuser);
	}
	
}