package com.tkmybaitsdemo.demo.service;

import com.github.pagehelper.PageInfo;
import com.tkmybaitsdemo.demo.entity.TestUser;
import com.tkmybaitsdemo.demo.util.BaseService;
import com.tkmybaitsdemo.demo.util.PageRequest;

public interface TestUserService extends BaseService<TestUser> {


    boolean insertTestUser(TestUser student);

    boolean updateTestUser(TestUser student);

    PageInfo<TestUser> pageQuery(PageRequest pageRequest);

    boolean deleteUserById(Integer id);

}
