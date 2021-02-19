/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.novel.entity;

import com.thinkgem.jeesite.modules.sys.entity.User;
import java.util.Date;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 用户阅读小说Entity
 * @author 用户阅读小说
 * @version 2021-02-19
 */
public class UserNovel extends DataEntity<UserNovel> {
	
	private static final long serialVersionUID = 1L;
	private Nuser user;		// 用户
	private Novel n;		// 小说
	private String ydcount;		// 阅读量
	private NovelChapter c;		// 章节
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	
	public UserNovel() {
		super();
	}

	public UserNovel(String id){
		super(id);
	}

	public Nuser getUser() {
		return user;
	}

	public void setUser(Nuser user) {
		this.user = user;
	}
	
	public Novel getN() {
		return n;
	}

	public void setN(Novel n) {
		this.n = n;
	}
	
	@Length(min=0, max=11, message="阅读量长度必须介于 0 和 11 之间")
	public String getYdcount() {
		return ydcount;
	}

	public void setYdcount(String ydcount) {
		this.ydcount = ydcount;
	}
	
	public NovelChapter getC() {
		return c;
	}

	public void setC(NovelChapter c) {
		this.c = c;
	}
	
	public Date getBeginCreateDate() {
		return beginCreateDate;
	}

	public void setBeginCreateDate(Date beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}
	
	public Date getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}
		
}