package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store =  new HashMap<>(); // Key : 회원ID 값은 Member
    private static long sequence =  0L;   // Key값을 생성해주는 변수


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // Null이 반환되는걸 Optional로 감싸준다.
    }

        @Override
        public Optional<Member> findByName(String name) {
            return store.values().stream()
                    .filter(member -> member.getName().equals(name))
                    .findAny();
        }


        @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void  clearStore() {
        store.clear(); // store를 clear
    }
}
