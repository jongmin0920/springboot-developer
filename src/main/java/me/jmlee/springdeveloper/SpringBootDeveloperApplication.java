package me.jmlee.springdeveloper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //시작점
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        // 스프링 부트 실행.
        SpringApplication.run(SpringBootDeveloperApplication.class, args); // run안에 클래스이름 넣기
    }
    // main 클래스
}