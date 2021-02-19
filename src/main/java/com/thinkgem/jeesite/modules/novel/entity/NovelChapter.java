/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.novel.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 小说管理Entity
 * @author 小说管理
 * @version 2021-02-19
 */
public class NovelChapter extends DataEntity<NovelChapter> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String xh;		// 序号
	private String content;		// 内容
	private Novel n;		// n_id 父类
	
	public NovelChapter() {
		super();
	}

	public NovelChapter(String id){
		super(id);
	}

	public NovelChapter(Novel n){
		this.n = n;
	}

	@Length(min=0, max=255, message="名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=11, message="序号长度必须介于 0 和 11 之间")
	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}
	
	@Length(min=0, max=255, message="内容长度必须介于 0 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=32, message="n_id长度必须介于 0 和 32 之间")
	public Novel getN() {
		return n;
	}

	public void setN(Novel n) {
		this.n = n;
	}
	
}