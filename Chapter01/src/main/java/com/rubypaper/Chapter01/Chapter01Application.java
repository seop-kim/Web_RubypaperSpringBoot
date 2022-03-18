package com.rubypaper.Chapter01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter01Application {

    public static void main(String[] args) {
        //SpringApplication.run(Chapter01Application.class, args);

        /**
         * 웹 애플리케이션이 아닌 자바 애플리케이션으로 실행시키는 방법
         * 스프링애플리케이션 객체를 생성하여 해당 객체에 setWebApp~ 를 NONE으로 설정하기
         * NONE 이 아닌 SERVLET 으로 설정하면 다시 웹으로 실행이 된다.
         */
        SpringApplication application = new SpringApplication(Chapter01Application.class);

        // 자바 애플리케이션으로 실행
        //application.setWebApplicationType(WebApplicationType.NONE);

        // 웹 서버로 실행
        application.setWebApplicationType(WebApplicationType.SERVLET);

        application.run(args);
    }

}
