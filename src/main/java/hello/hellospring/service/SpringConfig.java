package hello.hellospring.service;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean  // 자바코드를 사용해서 스프링 빈에 등록
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }



//    @Bean
//    public MemberRepository memberRepository() {

//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(datasource);
//        return new JdbcTemplateMemberRepository(datasource);
//        /
 //       }
}
