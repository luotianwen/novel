/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.novel.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.novel.entity.UserNovel;

/**
 * 用户阅读小说DAO接口
 * @author 用户阅读小说
 * @version 2021-02-19
 */
@MyBatisDao
public interface UserNovelDao extends CrudDao<UserNovel> {
	
}