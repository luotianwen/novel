/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.novel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.novel.entity.Novel;
import com.thinkgem.jeesite.modules.novel.dao.NovelDao;
import com.thinkgem.jeesite.modules.novel.entity.NovelChapter;
import com.thinkgem.jeesite.modules.novel.dao.NovelChapterDao;

/**
 * 小说管理Service
 * @author 小说管理
 * @version 2021-02-19
 */
@Service
@Transactional(readOnly = true)
public class NovelService extends CrudService<NovelDao, Novel> {

	@Autowired
	private NovelChapterDao novelChapterDao;
	
	public Novel get(String id) {
		Novel novel = super.get(id);
		novel.setNovelChapterList(novelChapterDao.findList(new NovelChapter(novel)));
		return novel;
	}
	
	public List<Novel> findList(Novel novel) {
		return super.findList(novel);
	}
	
	public Page<Novel> findPage(Page<Novel> page, Novel novel) {
		return super.findPage(page, novel);
	}
	
	@Transactional(readOnly = false)
	public void save(Novel novel) {
		super.save(novel);
		for (NovelChapter novelChapter : novel.getNovelChapterList()){
			if (novelChapter.getId() == null){
				continue;
			}
			if (NovelChapter.DEL_FLAG_NORMAL.equals(novelChapter.getDelFlag())){
				if (StringUtils.isBlank(novelChapter.getId())){
					novelChapter.setN(novel);
					novelChapter.preInsert();
					novelChapterDao.insert(novelChapter);
				}else{
					novelChapter.preUpdate();
					novelChapterDao.update(novelChapter);
				}
			}else{
				novelChapterDao.delete(novelChapter);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(Novel novel) {
		super.delete(novel);
		novelChapterDao.delete(new NovelChapter(novel));
	}
	
}