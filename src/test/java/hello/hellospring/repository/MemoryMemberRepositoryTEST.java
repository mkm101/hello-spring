package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTEST {

      MemoryMemberRepository repository = new MemoryMemberRepository();

      @AfterEach   //하나의 메소드가 끝날때마다 동작하는 Annotation
      public void afterEach(){
          repository.clearStore();
      }   // TEST는 서로 독립적으로 실행되어야하기 때문에, TEST가 끝날때마다 공용data들을 지워줘야한다.

      @Test
      public void save () {

            Member member = new Member();
            member.setName("Spring");

            repository.save(member);

            Member result = repository.findById(member.getId()).get(); // Optional같은경우 get으로 data를 꺼낸다.
            assertThat(member).isEqualTo(result);

      }
      @Test
      public void findByName() {
          Member member1 = new Member();
          member1.setName("spring1");
          repository.save(member1);

          Member member2 = new Member();
          member2.setName("spring2");
          repository.save(member2);

          Member result = repository.findByName("spring2").get();
          assertThat(member2).isEqualTo(result);
      }
      @Test
    public void findAll() {
          Member member1 = new Member();
          member1.setName("spring1");
          repository.save(member1);


          Member member2 = new Member();
          member2.setName("spring2");
          repository.save(member2);

          List<Member> result =repository.findAll();
          assertThat(result.size()).isEqualTo(2);


      }
}
