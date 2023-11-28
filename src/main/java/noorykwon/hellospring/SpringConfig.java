package noorykwon.hellospring;

import noorykwon.hellospring.aop.TimeTraceAop;
import noorykwon.hellospring.repository.*;
import noorykwon.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(mememberRepository());
    }

//    @Bean //aop는 인지하기 편하도록 되도록이면 컴포넌트스캔 방식보다 스프링 빈에 등록하는걸 권장
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

    @Bean
    public MemberRepository mememberRepository() {
//        return new MemoryMemberRepository(); //메모리객체
//        return new JdbcMemberRepository(dataSource); //기존코드를 변경하지 않고 구현체 변경 - JDBC드라이버로 H2연결
//        return new JdbcTemplateMemberRepository(dataSource); // JDBC 템플릿
        return new JpaMemberRepository(em);
    }
}
