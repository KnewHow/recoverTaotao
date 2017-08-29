package com.taotao.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A controller to jump page
 * 
 * @author yuangh
 *
 * @company erongdu
 *
 * @date 2017年8月29日
 */
@RequestMapping("page")
@Controller
public class PageController {
	/**
	 * Jump page into "WEB-INF/views/pagename.jsp"
	 * 
	 * @param pageName
	 *            The name of jsp page
	 * @return A view name
	 */
	@RequestMapping("{pageName}")
	public String jumpPage(@PathVariable(value = "pageName") String pageName) {
		return pageName;
	}
}
