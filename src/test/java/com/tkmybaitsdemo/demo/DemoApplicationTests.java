package com.tkmybaitsdemo.demo;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.tkmybaitsdemo.demo.entity.TestUser;
import com.tkmybaitsdemo.demo.service.TestUserService;
import com.tkmybaitsdemo.demo.util.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class DemoApplicationTests {


    @Autowired
    private TestUserService testUserService;


    /**
     * 查询所有用户
     */
    @Test
    public void test001() {
        List<TestUser> userPOList = this.testUserService.findAll();
        log.info("查询所有用户:{}", JSONUtil.toJsonPrettyStr(userPOList));
    }


    /**
     * 根据id查询
     */
    @Test
    public void test002() {
        Integer userId = 9;
        TestUser user = this.testUserService.findById(userId);
        log.info("根据id查询:{}", JSONUtil.toJsonPrettyStr(user));
    }


    /**
     * 根据id列表批量查询
     */
    @Test
    public void test003() {
        List<Integer> userIdList = Arrays.asList(1, 2);
        List<String> userIds = userIdList.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        String userId = String.join(",", userIds);
                ;
        List<TestUser> userPOList = this.testUserService.findByIds(userId);
        log.info("根据id列表批量查询:{}", JSONUtil.toJsonPrettyStr(userPOList));
    }



    /**
     * 插入记录，id 手动填充
     */
    @Test
    public void test004() {
        TestUser testUser = TestUser.builder()
                .id(10)
                .userName("luren10")
                .age(32)
                .build();
        boolean isInsert = this.testUserService.insertTestUser(testUser);
        log.info("isInsert:{}", isInsert);
        //查询最新记录
        testUser = this.testUserService.findById(testUser.getId());
        log.info("accountPO:{}", JSONUtil.toJsonPrettyStr(testUser));
    }



    /**
     * 按照主键更新一个对象
     */
    @Test
    public void test05() {
        Integer accountId = 10;
        //更新前
        TestUser testUser = this.testUserService.findById(accountId);
        log.info("更新前 testUser：{}", JSONUtil.toJsonPrettyStr(testUser));

        //更新
        testUser.setUserName("路人10");
        boolean isUpdate= this.testUserService.updateTestUser(testUser);
        log.info("isUpdate:{}", isUpdate);

        //更新后，查询最新记录
        testUser = this.testUserService.findById(accountId);
        log.info("更新后 testUser:{}", JSONUtil.toJsonPrettyStr(testUser));
    }



    /**
     * 根据主键删除记录
     */
    @Test
    public void test06() {
        boolean isDelete = this.testUserService.deleteUserById(11);
        log.info("根据主键删除记录，isDelete：{}", isDelete);
    }



    /**
     * 分页查询
     */
    @Test
    public void test07() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(1);
        pageRequest.setPageSize(5);
        PageInfo<TestUser> testUserPageInfo = this.testUserService.pageQuery(pageRequest);
        log.info("查询分页数据为，testUserPageInfo：{}", testUserPageInfo.getList());
    }






}
