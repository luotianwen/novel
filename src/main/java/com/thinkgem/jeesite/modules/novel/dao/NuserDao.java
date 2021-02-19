/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.novel.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.novel.entity.Nuser;

/**
 * 用户管理DAO接口
 * @author 用户管理
 * @version 2021-02-19
 */
@MyBatisDao
public interface NuserDao extends CrudDao<Nuser> {
	
}