package com.dongyp.demo.dao;

import com.dongyp.demo.domain.User;

import java.util.List;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/6
 */
public interface IUserJDBCDao {
    int insert(User user);

    int update(User user);

    int delete(User user);

    User findOne(String username);

    List<User> find();
}
