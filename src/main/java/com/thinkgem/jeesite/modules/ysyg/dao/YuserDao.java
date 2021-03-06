/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ysyg.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.ysyg.entity.Yuser;

/**
 * 用户管理DAO接口
 * @author 用户管理
 * @version 2021-01-28
 */
@MyBatisDao
public interface YuserDao extends CrudDao<Yuser> {
	
}