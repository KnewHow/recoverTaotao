package cn.itcast.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Page jump controller
 * 
 * @author yuangh
 *
 * @company erongdu
 *
 * @data 2017年8月28日
 */

@Controller
public class PageController {

	/**
	 * A method to jump page from /page/pageName to /WEB-INF/views/pageName.jsp
	 * 
	 * @param pageName
	 *            The page name of page
	 * @return A view name
	 */
	@RequestMapping(value = "page/{pageName}", method = RequestMethod.GET)
	public String pageJump(@PathVariable("pageName") String pageName) {
		return pageName;
	}
}
