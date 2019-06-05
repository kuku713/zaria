package com.kuku.zaria;

import com.alibaba.fastjson.JSONObject;
import com.kuku.zaria.domain.mapper.MenuMapper;
import com.kuku.zaria.domain.mapper.UserMapper;
import com.kuku.zaria.util.MenuUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sound.midi.Track;

/**
 * @author kuku713
 * @description
 * @date 2019-05-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = {"com.kuku.zaria.domain.mapper"})
public class RepositoryTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;

    @Test
    public void test() {
        System.out.println(userMapper.getByUserId("admin"));
    }

    @Test
    public void menuTest() {
        System.out.println(JSONObject.toJSONString(
                MenuUtils.convertMenuTree(menuMapper.listAllMenus()), true));
    }
}
