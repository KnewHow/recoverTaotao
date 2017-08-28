package cn.itcast.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.mbatis.bean.EasyUIResult;
import cn.itcast.mbatis.service.NewUserService;
import cn.itcast.mybatis.pojo.User;

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
	private NewUserService userService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public EasyUIResult queryUserList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "rows", defaultValue = "5") Integer rows) {
		return this.userService.queryUserList(page, rows);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> queryUserById(@PathVariable("id") Long id) {
		try {
			User user = this.userService.queryUserById(id);
			if (user == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			} else {
				// return ResponseEntity.status(HttpStatus.OK).body(user);
				return ResponseEntity.ok(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

	}
}
