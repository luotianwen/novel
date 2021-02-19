/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.novel.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.novel.entity.Nuser;
import com.thinkgem.jeesite.modules.novel.service.NuserService;

/**
 * 用户管理Controller
 * @author 用户管理
 * @version 2021-02-19
 */
@Controller
@RequestMapping(value = "${adminPath}/novel/nuser")
public class NuserController extends BaseController {

	@Autowired
	private NuserService nuserService;
	
	@ModelAttribute
	public Nuser get(@RequestParam(required=false) String id) {
		Nuser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nuserService.get(id);
		}
		if (entity == null){
			entity = new Nuser();
		}
		return entity;
	}
	
	@RequiresPermissions("novel:nuser:view")
	@RequestMapping(value = {"list", ""})
	public String list(Nuser nuser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Nuser> page = nuserService.findPage(new Page<Nuser>(request, response), nuser); 
		model.addAttribute("page", page);
		return "modules/novel/nuserList";
	}

	@RequiresPermissions("novel:nuser:view")
	@RequestMapping(value = "form")
	public String form(Nuser nuser, Model model) {
		model.addAttribute("nuser", nuser);
		return "modules/novel/nuserForm";
	}

	@RequiresPermissions("novel:nuser:edit")
	@RequestMapping(value = "save")
	public String save(Nuser nuser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nuser)){
			return form(nuser, model);
		}
		nuserService.save(nuser);
		addMessage(redirectAttributes, "保存用户管理成功");
		return "redirect:"+Global.getAdminPath()+"/novel/nuser/?repage";
	}
	
	@RequiresPermissions("novel:nuser:edit")
	@RequestMapping(value = "delete")
	public String delete(Nuser nuser, RedirectAttributes redirectAttributes) {
		nuserService.delete(nuser);
		addMessage(redirectAttributes, "删除用户管理成功");
		return "redirect:"+Global.getAdminPath()+"/novel/nuser/?repage";
	}

}