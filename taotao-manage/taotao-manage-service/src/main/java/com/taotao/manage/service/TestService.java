package com.taotao.manage.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taotao.common.exception.TestException;
import com.taotao.manage.pojo.User;
import com.taotao.manage.pojo.UserItem;

/**
 * A service just to test spring transaction it use the user and user item to
 * test. The two domain just for test to produce
 * 
 * @author yuanghohao
 * 
 * @company erongdu
 *
 * @date 2017年9月17日
 */
@Service
public class TestService extends BaseService<User> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TestService.class);

	@Autowired
	private UserItemService userItemService;

	/**
	 * 测试插入数据库
	 * 
	 * @throws TestException
	 */
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void testInsert() {
		for (int i = 0; i < 10; i++) {
			User user = new User();
			if (i == 100) {
				TestException e = new TestException("test exception");
				LOGGER.error("插入数据异常", e);
				throw e;
			}
			user.setUserId(i + "");
			user.setUsername("ygh" + i);
			this.mapper.insert(user);
		}

		// User user = new User();
		// user.setUserId(0 + "");
		// user.setUsername("ygh" + 0);
		// this.mapper.insert(user);
		// int a=1/0;
		// user.setUserId(1+ "");
		// user.setUsername("ygh" + 1);
		// this.mapper.insert(user);
	}

//	@Transactional(readOnly = false)
	public void testInserUserItem() {
		List<User> userList = this.queryAll();
		for (User user : userList) {
			try {
				testInsertData(user);
			} catch (Exception e) {
				LOGGER.error("插入数据出错",e);
				continue;
			}
		}
//		int a = 1/0;
	}
	
	@Transactional(readOnly = false)
	private void testInsertData(User user){
		if (user.getUserId().equals("9")) {
			TestException e = new TestException("test exception");
			LOGGER.error("插入数据异常", e);
			throw e;
		}
		for (int i = 0; i < 10; i++) {
			UserItem item = new UserItem();
			item.setUserId(user.getUserId());
			item.setSex(user.getUsername() + i);
			this.userItemService.save(item);
		}
	}

}
