package com.kuku.zaria.controller.common;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author kuku713
 * @description
 * @date 2019-06-05
 */
@Slf4j
@Controller
public class KaptchaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    public void genCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // 生产验证码字符串并保存到session中
        String captchaCode = defaultKaptcha.createText();
        request.getSession().setAttribute("captchaCode", captchaCode);
        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        ImageIO.write(defaultKaptcha.createImage(captchaCode), "jpg", outputStream);
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-store");
        response.setHeader(HttpHeaders.PRAGMA, "no-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, 0);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        response.getOutputStream().write(outputStream.toByteArray());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}
