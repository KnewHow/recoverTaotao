package com.taotao.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.common.exception.TestException;
import com.taotao.manage.service.TestService;


/**
 * 
 * @author yuanghohao
 * 
 * @company erongdu
 *
 * @date 2017年9月17日
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;

	/*
	 * 测试插入user 的事务管理
	 */
	@RequestMapping("insert")
	public void testInsert() throws TestException {
		this.testService.testInsert();
	}
	/*
	 * 测试插入user 的事务管理
	 */
	@RequestMapping("insertItem")
	public void testInsertItem() throws TestException {
		this.testService.testInserUserItem();
	}

}
