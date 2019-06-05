package com.kuku.zaria.controller;

import com.kuku.zaria.bean.dto.BaseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kuku713
 * @description
 * @date 2019-06-04
 */
@Slf4j
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public BaseDTO testJson(HttpServletRequest request) {
        return new BaseDTO("1", "/test");
    }

}
