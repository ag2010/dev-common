package com.tkmybaitsdemo.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tkmybaitsdemo.demo.entity.TestUser;
import com.tkmybaitsdemo.demo.exception.BizException;
import com.tkmybaitsdemo.demo.service.TestUserService;
import com.tkmybaitsdemo.demo.util.AbstractService;
import com.tkmybaitsdemo.demo.util.PageRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TestUserServiceImpl extends AbstractService<TestUser> implements TestUserService {


    @Override
    @Transactional(rollbackFor = BizException.class)
    public boolean insertTestUser(TestUser testUser) {
        this.save(testUser);
        return true;
    }

    @Override
    @Transactional(rollbackFor = BizException.class)
    public boolean updateTestUser(TestUser testUser) {
        update(testUser);
        return true;
    }

    @Override
    public PageInfo<TestUser> pageQuery(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<TestUser> all = this.findAll();

        return new PageInfo<>(all);
    }


    @Override
    @Transactional(rollbackFor = BizException.class)
    public boolean deleteUserById(Integer id) {
        deleteById(id);
        return true;
    }

}
