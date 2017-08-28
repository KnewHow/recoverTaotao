package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.pojo.User;

public interface UserMapper {

	public List<User> findUserList();
}
