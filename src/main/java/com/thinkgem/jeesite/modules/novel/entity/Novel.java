/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.novel.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import java.util.List;
import com.google.common.collect.Lists;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 小说管理Entity
 * @author 小说管理
 * @version 2021-02-19
 */
public class Novel extends DataEntity<Novel> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String author;		// 作者
	private String type;		// 分类
	private String sex;		// 性别
	private String pto;		// 封面
	private String ydcount;		// 阅读次数
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	private List<NovelChapter> novelChapterList = Lists.newArrayList();		// 子表列表
	
	public Novel() {
		super();
	}

	public Novel(String id){
		super(id);
	}

	@Length(min=0, max=255, message="名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="作者长度必须介于 0 和 255 之间")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Length(min=0, max=255, message="分类长度必须介于 0 和 255 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=255, message="性别长度必须介于 0 和 255 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=255, message="封面长度必须介于 0 和 255 之间")
	public String getPto() {
		return pto;
	}

	public void setPto(String pto) {
		this.pto = pto;
	}
	
	@Length(min=0, max=11, message="阅读次数长度必须介于 0 和 11 之间")
	public String getYdcount() {
		return ydcount;
	}

	public void setYdcount(String ydcount) {
		this.ydcount = ydcount;
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
		
	public List<NovelChapter> getNovelChapterList() {
		return novelChapterList;
	}

	public void setNovelChapterList(List<NovelChapter> novelChapterList) {
		this.novelChapterList = novelChapterList;
	}
}