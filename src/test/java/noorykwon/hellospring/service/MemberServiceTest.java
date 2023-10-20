package noorykwon.hellospring.service;

import noorykwon.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    //테스트코드는 과감하게 한글메소드로 설정해도됨!

    MemberService memberService = new MemberService();

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(member.getId()).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member memeber1 = new Member();
        memeber1.setName("spring");

        Member memeber2 = new Member();
        memeber2.setName("spring");

        //when
        memberService.join(memeber1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(memeber2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


//        try {
//            memberService.join(memeber2);
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}