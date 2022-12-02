package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

       Member save(Member member); //
       Optional<Member> findById(Long id);  // id로 회원을 찾는 기능  id에 해당하는 회원이 없으면, Null 대신 Optional로 감싸서 반환
       Optional<Member> findByName(String name);
       List<Member> findAll(); // 저장된 모든 회원List를 반환
       
}
