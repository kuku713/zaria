package com.kuku.zaria.controller;

import com.kuku.zaria.bean.dto.BaseDTO;
import com.kuku.zaria.util.DTOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author kuku713
 * @description
 * @date 2019-06-04
 */
@Slf4j
@RestController
public class NotFoundController implements ErrorController {

    private static final BaseDTO ERROR_URL_DTO = DTOUtils.genFailUserDTO("错误的URL");

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    public BaseDTO errorDTO() {
        return ERROR_URL_DTO;
    }
}
