/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.novel.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 用户管理Entity
 * @author 用户管理
 * @version 2021-02-19
 */
public class Nuser extends DataEntity<Nuser> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String account;		// 账号
	private String pass;		// 密码
	private String nk;		// 昵称
	private String sex;		// 性别
	private Date br;		// 生日
	private String pto;		// 头像
	private String area;		// 地区
	private String email;		// 邮箱
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	private Date beginBr;		// 开始 生日
	private Date endBr;		// 结束 生日
	
	public Nuser() {
		super();
	}

	public Nuser(String id){
		super(id);
	}

	@Length(min=0, max=255, message="名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="账号长度必须介于 0 和 255 之间")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	@Length(min=0, max=255, message="密码长度必须介于 0 和 255 之间")
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Length(min=0, max=255, message="昵称长度必须介于 0 和 255 之间")
	public String getNk() {
		return nk;
	}

	public void setNk(String nk) {
		this.nk = nk;
	}
	
	@Length(min=0, max=255, message="性别长度必须介于 0 和 255 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBr() {
		return br;
	}

	public void setBr(Date br) {
		this.br = br;
	}
	
	@Length(min=0, max=255, message="头像长度必须介于 0 和 255 之间")
	public String getPto() {
		return pto;
	}

	public void setPto(String pto) {
		this.pto = pto;
	}
	
	@Length(min=0, max=255, message="地区长度必须介于 0 和 255 之间")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=0, max=255, message="邮箱长度必须介于 0 和 255 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		
	public Date getBeginBr() {
		return beginBr;
	}

	public void setBeginBr(Date beginBr) {
		this.beginBr = beginBr;
	}
	
	public Date getEndBr() {
		return endBr;
	}

	public void setEndBr(Date endBr) {
		this.endBr = endBr;
	}
		
}