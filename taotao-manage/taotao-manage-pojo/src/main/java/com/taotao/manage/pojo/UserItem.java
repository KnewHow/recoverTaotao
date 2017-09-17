package com.taotao.manage.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户详情类，只是为了测试spring的事务使用，没有实际意义
 * 
 * @author yuanghohao
 * 
 * @company erongdu
 *
 * @date 2017年9月17日
 */
@Table(name="user_item")
public class UserItem extends BasePojo{
	private String userId;

	private String sex;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "UserItem [userId=" + userId + ", sex=" + sex + "]";
	}

}
