package com.korit.boardback.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

// 이미지 파일
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${user.dir}")
    private String rootPath;

//    resourceHandler들을 추가하는 메서드
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**") // 이미지 주소 "/image" 설정 후 이 주소로 요청이 들어오면
                .addResourceLocations("file:" + rootPath + "/upload") // "file:" + rootPath + "/upload" 주소 형태로 변경 해라
                .resourceChain(true) // 두 주소 연결
                .addResolver(new PathResourceResolver() {
                    @Override
                    protected Resource getResource(String resourcePath, Resource location) throws IOException { // 리소스 가져와사
                        resourcePath = URLDecoder.decode(resourcePath, StandardCharsets.UTF_8); // 파일 명 한글인 경우 변환해서
                        return super.getResource(resourcePath, location); // 호춯 시 변환된 형태의 리소스(주소) 적용
                    }
                });
    }
}
