package org.generation.foodhunters.security;

import org.springframework.beans.factory.annotation.Value;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${image.folder}")
    private String imageFolder; //now imageFolder variable the value = productimages


    public void addViewControllers (ViewControllerRegistry registry) {
        //Map the browser's URL to a specific View (HTML) inside resources/templates directory
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/aboutus").setViewName("aboutus");
        registry.addViewController("/forumMain").setViewName("forumMain");
        registry.addViewController("/forumHawker").setViewName("forumHawker");
        registry.addViewController("/FoodTour").setViewName("FoodTour");
        registry.addViewController("/crazyRichAsianTour").setViewName("crazyRichAsianTour");
        registry.addViewController("/forumRestaurant").setViewName("forumRestaurant");
        registry.addViewController("/forumOverseas").setViewName("forumOverseas");
        registry.addViewController("/common/foodTourDetails").setViewName("foodTourDetails");
        registry.addViewController("/maharajaTour").setViewName("maharajaTour");
        registry.addViewController("/emperorTour").setViewName("emperorTour");
        registry.addViewController("/sultanTour").setViewName("sultanTour");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);

        Path uploadDir = Paths.get(imageFolder);
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/" + imageFolder + "/**")
                .addResourceLocations("file:" + uploadPath + "/")
                .setCachePeriod(0);

    }


}
