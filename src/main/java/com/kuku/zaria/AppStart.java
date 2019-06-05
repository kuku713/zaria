package com.kuku.zaria;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import tk.mybatis.spring.annotation.MapperScan;

import java.nio.charset.Charset;
import java.util.Collections;

/**
 * @author kuku713
 * @description
 * @date 2019-05-12
 */
@EnableCaching
@SpringBootApplication
@MapperScan(basePackages = {"com.kuku.zaria.domain.mapper"})
public class AppStart {

    public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1、需要先定义一个 convert 转换消息对象；
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 2、添加 fastJson 的配置信息，比如: 是否要格式化返回的Json数据；
        FastJsonConfig config = new FastJsonConfig();
        config.setCharset(Charset.forName("utf8"));
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        // 3、在 Convert 中添加配置信息;
        fastConverter.setFastJsonConfig(config);
        fastConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
        // 4、返回对象
        return new HttpMessageConverters((HttpMessageConverter<?>) fastConverter);
    }
}
