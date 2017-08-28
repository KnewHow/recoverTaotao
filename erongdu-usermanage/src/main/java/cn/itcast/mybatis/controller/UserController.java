package cn.itcast.mybatis.controller;

import javax.jws.soap.SOAPBinding.Use;

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

	/**
	 * Query User By id
	 * 
	 * @param id
	 *            The id of user
	 * @return A {@link ResponseEntity} witch contains data
	 */
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

	/**
	 * Save User
	 * 
	 * @param user
	 *            A User object
	 * @return A {@link ResponseEntity} witch only contains HTTP status
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveUser(User user) {
		try {
			this.userService.saveUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Update user information
	 * 
	 * @param user
	 *            A user object
	 * @return A {@link ResponseEntity} witch only contains HTTP status
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(User user) {
		try {
			this.userService.updateUser(user);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Delete user by id
	 * 
	 * @param id
	 *            The id of user
	 * @return A {@link ResponseEntity} witch only contains HTTP status
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUserById(@RequestParam(value = "id", defaultValue = "0") Long id) {
		try {
			this.userService.deleteUserById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
