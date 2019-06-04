package com.kuku.zaria.domain.mapper;

import com.kuku.zaria.domain.entity.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author luzh21574
 * @description
 * @date 2019-05-12
 */
public interface UserMapper extends Mapper<User> {

    /**
     * 根据用户Id查询
     * @param userId
     * @return
     */
    User getByUserId(String userId);

    /**
     * 根据手机号查询
     * @param mobile
     * @return
     */
    User getByMobile(String mobile);

    /**
     * 根据邮箱查询
     * @param email
     * @return
     */
    User getByEmail(String email);

}
