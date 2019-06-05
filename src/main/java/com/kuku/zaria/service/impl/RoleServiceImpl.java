package com.kuku.zaria.service.impl;

import com.kuku.zaria.bean.dto.RoleDTO;
import com.kuku.zaria.domain.mapper.RoleMapper;
import com.kuku.zaria.service.RoleService;
import com.kuku.zaria.util.DTOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kuku713
 * @description
 * @date 2019-06-05
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public RoleDTO listUserRolesByUserId(String userId) {
        return DTOUtils.genSuccessRoleDTO(roleMapper.listRolesByUserId(userId));
    }

}
