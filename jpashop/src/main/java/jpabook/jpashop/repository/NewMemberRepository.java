package jpabook.jpashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpabook.jpashop.domain.Member;
import java.util.List;


public interface NewMemberRepository extends JpaRepository<Member, Long>{
    
    List<Member> findByName(String name);
}
