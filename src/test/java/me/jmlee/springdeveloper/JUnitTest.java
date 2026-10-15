package me.jmlee.springdeveloper;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class JUnitTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("전체 시작 전 1번");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("각 테스트 전");
    }

    @Test
    @DisplayName("1 더하기 2는 3이다")
    void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

        assertThat(a + b).isEqualTo(sum);
    }

    @AfterEach
    void afterEach() {
        System.out.println("각 테스트 후");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("전체 끝난 후 1번");
    }
}