package com.kuku.zaria;

import com.kuku.zaria.domain.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author luzh21574
 * @description
 * @date 2019-05-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = {"com.kuku.zaria.domain.mapper"})
public class RepositoryTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test() {
        System.out.println(userMapper.getByUserId("admin"));
    }

}
