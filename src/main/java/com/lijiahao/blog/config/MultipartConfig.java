package com.lijiahao.blog.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

@Configuration
public class MultipartConfig {
	/**
     * 配置上传文件大小的配置
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize(DataSize.ofKilobytes(10240L));
        /// 总上传数据大小
        factory.setMaxRequestSize(DataSize.ofKilobytes(10240L));
        return factory.createMultipartConfig();
    }
}
