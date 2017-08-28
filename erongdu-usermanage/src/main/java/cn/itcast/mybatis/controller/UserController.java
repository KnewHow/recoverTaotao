package cn.itcast.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.mbatis.bean.EasyUIResult;
import cn.itcast.mbatis.service.UserService;

/**
 * User Controller
 * 
 * @author yuangh
 *
 * @company erongdu
 *
 * @data 2017年8月28日
 */

@Controller
@RequestMapping("user")
public class UserController {
	
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public EasyUIResult queryUserList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value="rows",defaultValue="5") Integer rows) {
		return this.userService.queryUserList(page,rows);
	}
}
