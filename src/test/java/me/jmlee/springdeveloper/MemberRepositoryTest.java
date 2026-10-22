package me.jmlee.springdeveloper;

import me.jmlee.springdeveloper.entity.Member;
import me.jmlee.springdeveloper.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원을 저장하면 id가 생기고 이름이 같다")
    void saveMember() {
        // given
        Member member = new Member("SpringUser", "spring@test.com");

        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertThat(savedMember.getId()).isNotNull();
        assertThat(savedMember.getName()).isEqualTo("SpringUser");
    }

    @Test
    @DisplayName("이름으로 회원을 조회할 수 있다")
    void findByName() {
        // given
        memberRepository.save(new Member("TestUser", "test@test.com"));

        // when
        Member found = memberRepository.findByName("TestUser").orElseThrow();

        // then
        assertThat(found.getEmail()).isEqualTo("test@test.com");
    }

    @Test
    @DisplayName("회원을 삭제하면 조회되지 않는다")
    void deleteMember() {
        // given
        Member saved = memberRepository.save(new Member("DeleteUser", "del@test.com"));

        // when
        memberRepository.deleteById(saved.getId());

        // then
        assertThat(memberRepository.existsById(saved.getId())).isFalse();
    }
}