package noorykwon.hellospring;

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

    @Bean
    public MemberRepository mememberRepository() {
//        return new MemoryMemberRepository(); //메모리객체
//        return new JdbcMemberRepository(dataSource); //기존코드를 변경하지 않고 구현체 변경 - JDBC드라이버로 H2연결
//        return new JdbcTemplateMemberRepository(dataSource); // JDBC 템플릿
        return new JpaMemberRepository(em);
    }
}
