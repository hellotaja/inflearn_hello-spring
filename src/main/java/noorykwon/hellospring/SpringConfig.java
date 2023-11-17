package noorykwon.hellospring;

import noorykwon.hellospring.repository.MemberRepository;
import noorykwon.hellospring.repository.MemoryMemberRepository;
import noorykwon.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(mememberRepository());
    }

    @Bean
    public MemberRepository mememberRepository() {
        return new MemoryMemberRepository();
    }
}
