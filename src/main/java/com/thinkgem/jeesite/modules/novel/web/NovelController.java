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
import com.thinkgem.jeesite.modules.novel.entity.Novel;
import com.thinkgem.jeesite.modules.novel.service.NovelService;

/**
 * 小说管理Controller
 * @author 小说管理
 * @version 2021-02-19
 */
@Controller
@RequestMapping(value = "${adminPath}/novel/novel")
public class NovelController extends BaseController {

	@Autowired
	private NovelService novelService;
	
	@ModelAttribute
	public Novel get(@RequestParam(required=false) String id) {
		Novel entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = novelService.get(id);
		}
		if (entity == null){
			entity = new Novel();
		}
		return entity;
	}
	
	@RequiresPermissions("novel:novel:view")
	@RequestMapping(value = {"list", ""})
	public String list(Novel novel, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Novel> page = novelService.findPage(new Page<Novel>(request, response), novel); 
		model.addAttribute("page", page);
		return "modules/novel/novelList";
	}

	@RequiresPermissions("novel:novel:view")
	@RequestMapping(value = "form")
	public String form(Novel novel, Model model) {
		model.addAttribute("novel", novel);
		return "modules/novel/novelForm";
	}

	@RequiresPermissions("novel:novel:edit")
	@RequestMapping(value = "save")
	public String save(Novel novel, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, novel)){
			return form(novel, model);
		}
		novelService.save(novel);
		addMessage(redirectAttributes, "保存小说管理成功");
		return "redirect:"+Global.getAdminPath()+"/novel/novel/?repage";
	}
	
	@RequiresPermissions("novel:novel:edit")
	@RequestMapping(value = "delete")
	public String delete(Novel novel, RedirectAttributes redirectAttributes) {
		novelService.delete(novel);
		addMessage(redirectAttributes, "删除小说管理成功");
		return "redirect:"+Global.getAdminPath()+"/novel/novel/?repage";
	}

}