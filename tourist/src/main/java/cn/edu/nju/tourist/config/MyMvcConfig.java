package cn.edu.nju.tourist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类
 *
 * @author fanleehao on 2019/1/15
 */

//@EnableWebMvc  //全面接管MVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //发送请求直接到页面
        registry.addViewController("/test").setViewName("index2");
    }

    //返回一组视图解析器
    @Bean //将组件注册到容器中
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer wmc = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("success");
                registry.addViewController("/index.html").setViewName("index");
                //registry.addViewController("/addpost.html").setViewName("addPost");
            }

            /**
             * 注册拦截器
             * @param registry
             */
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //registry.addInterceptor(new );
//            }
        };
        return wmc;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/image/**").addResourceLocations("classpath:/image/");
    }
}
