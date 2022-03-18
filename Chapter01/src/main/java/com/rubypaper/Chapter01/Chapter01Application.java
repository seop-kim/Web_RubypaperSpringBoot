package com.rubypaper.Chapter01;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rubypaper", "com.ruby"})
public class Chapter01Application {

    public static void main(String[] args) {
        //SpringApplication.run(Chapter01Application.class, args);

        /**
         * 웹 애플리케이션이 아닌 자바 애플리케이션으로 실행시키는 방법
         * 스프링애플리케이션 객체를 생성하여 해당 객체에 setWebApp~ 를 NONE으로 설정하기
         * NONE 이 아닌 SERVLET 으로 설정하면 다시 웹으로 실행이 된다.
         */
        SpringApplication application = new SpringApplication(Chapter01Application.class);

        /**
         * 아래 방법 이외에 서버를 application.properties 파일을 통해 수정하는 방법도 있다.
         * 또한 application.properties 의 우선 순위가 높기에 class 파일에서 설정한 값은 반영되지 않는다.
         */
        // 자바 애플리케이션으로 실행
        //application.setWebApplicationType(WebApplicationType.NONE);

        // 웹 서버로 실행
        application.setWebApplicationType(WebApplicationType.SERVLET);


        /**
         * 커스텀 배너 사용 방법은 resources 폴더 내 banner.txt 파일에 출력할 테스트를 작성하면
         * 자동으로 커스텀한 배너가 출력이 된다.
         * application.properties 파일에서 배너 모드를 수정할 수도 있다.
         */
        // 실행 시 배너 끄기
        // application.setBannerMode(Banner.Mode.OFF);


        application.run(args);
    }
}
